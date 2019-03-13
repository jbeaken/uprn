package org.endeavourhealth.propertymatcher;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.endeavourhealth.propertymatcher.bean.ONSAddress;
import org.endeavourhealth.propertymatcher.bean.CSVAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PropertymatcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropertymatcherApplication.class, args);
    }
}

@Component
final class CommandLineAppStartupRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    private final String url = "http://localhost:9001/addresses?verbose=true&matchthreshold=5&rangekm=&historical=true&offset=0&classificationfilter=&lon=-3.5091076&enddate=&limit=10&input=";

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    private CSVPrinter csvPrinter;

    private final ObjectMapper mapper = new ObjectMapper();

    private String csvInput;
    private String csvOutput;

    final int counterStart = 0;
    final int counterEnd = 100_000_000;
    final long start = System.currentTimeMillis();

    public void run(String... args) throws Exception {

        logger.info("Import of csv started with command-line arguments: {} .", Arrays.toString(args));

        String csvType = args[0];

        initialise(csvType);

        initialiseCSVPrinter();

        processRecords(csvType);

        long end = System.currentTimeMillis();

        logger.info("Finished!! Have processed {} records in {} milliseconds", (counterEnd - counterStart), (end - start));

        logger.info("Start position {} to end {}", counterStart, counterEnd);

        csvPrinter.flush();
        csvPrinter.close();
    }


    private void initialise(String csvType) {
        if(csvType.equals("unmatched")) {
            csvInput = "/media/ext/LearningHealth/batch/input/unmatched.csv";
            csvOutput = "/media/ext/LearningHealth/batch/output/unmatched.csv";
        } else if(csvType.equals("unmatched")) {
            csvInput = "/media/ext/LearningHealth/batch/input/discovery.csv";
            csvOutput = "/media/ext/LearningHealth/batch/output/discovery" + start + ".csv";
        } else throw new RuntimeException(csvType + " csvType not supported!");
    }

    private void processRecords(String csvType) throws IOException {

        logger.info("Processing records for type {}", csvType);

        int counter = 0;

        Iterable<CSVRecord> records = readCSVRecords();

        for (CSVRecord record : records) {

            counter++;

            CSVAddress csvAddress = null;

            if (counter < counterStart) continue;

            if (csvType.equals("unmatched")) {
                csvAddress = CSVAddress.getUnmatchedCSVAddress(record);
            } else {
                csvAddress = CSVAddress.getDiscoveryCSVAddress(record);
            }

            String json = getResponseFromOnsServer(csvAddress);

            ONSAddress onsAddress = getOnsAddressFromJson(json);

            printToCsv(csvAddress, onsAddress);

            if (counter % 100 == 0) {
                long end = System.currentTimeMillis();
                logger.info("Have processed {} records in {} milliseconds", counter, (end - start));
            }

            if (counter == counterEnd) break;
        }
    }

    private Iterable<CSVRecord> readCSVRecords() throws IOException {

        Reader in = new FileReader( csvInput );

        return CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
    }

    private void initialiseCSVPrinter() throws IOException {

        Writer writer = new BufferedWriter(new FileWriter( csvOutput ));

        csvPrinter = new CSVPrinter(writer,
                CSVFormat.DEFAULT.withHeader(
                        "DiscoveryAddress",
                        "Score",
                        "ONSAddress",
                        "UPRN",
                        "Status",
                        "Classification",

                        //Import from discovery csv

                        "Line1",
                        "Line2",
                        "Line3",
                        "Line4",
                        "County",
                        "Postcode",
                        "OrgPostcode",
                        "PseudoPersonid"));
    }

    private ONSAddress getOnsAddressFromJson(String json) throws IOException {

        JsonNode root = mapper.readTree(json);

        Iterator<JsonNode> addresses = root.path("response").get("addresses").iterator();

        ONSAddress onsAddress = new ONSAddress();  //No match

        if (addresses.hasNext()) {

            onsAddress = getOnsAddress(addresses.next());

            while (addresses.hasNext()) {
                if (addresses.next().get("confidenceScore").doubleValue() > onsAddress.getConfidenceScore())
                    throw new RuntimeException("Confidence score for non-zero index is higher than zero index score");
            }

            onsAddress.setStatus("MATCH");

        }

        return onsAddress;
    }

    private ONSAddress getOnsAddress(JsonNode address) {
        ONSAddress onsAddress = new ONSAddress();

        onsAddress.setConfidenceScore(address.get("confidenceScore").asDouble());

        onsAddress.setFormattedAddress(address.get("formattedAddress").asText());

        onsAddress.setUprn(address.get("uprn").asText());

        onsAddress.setClassificationCode(address.get("classificationCode").asText());

//		JsonNode paf = address.get("paf");
//
//		if(paf != null) {
//			Paf p = new Paf(paf.get("postcode").asText(), paf.get("postTown").asText() );
//			onsAddress.setPaf(p);
//		}
//
//		JsonNode nag = address.get("nag");
//
//		if(nag != null) {
//			JsonNode node = nag.get(0);
//			Nag n = new Nag(node.get("postcodeLocator").asText(), node.get("locality").asText() );
//			onsAddress.setNag(n);
//		}

        return onsAddress;
    }

    private void printToCsv(CSVAddress csvAddress, ONSAddress address) throws IOException {

        csvPrinter.printRecord(
                csvAddress.getQ(),

                address.getConfidenceScore(),
                address.getFormattedAddress(),
                address.getUprn(),
                address.getStatus(),
                address.getClassificationCode(),

                csvAddress.getLine1(),
                csvAddress.getLine2(),
                csvAddress.getLine3(),
                csvAddress.getLine4(),
                csvAddress.getCounty(),
                csvAddress.getPostcode(),
                csvAddress.getOrgPostcode(),
                csvAddress.getPsuedoPersonId());


    }

    private String getResponseFromOnsServer(CSVAddress csvAddress) {

        String q = csvAddress.getQ().replace("#", "");

        logger.debug(q);

        ResponseEntity<String> stringEntity = restTemplate.getForEntity(url + q, String.class);

        return stringEntity.getBody();

    }

}
