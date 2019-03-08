package org.endeavourhealth.propertymatcher;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.endeavourhealth.propertymatcher.bean.Address;
import org.endeavourhealth.propertymatcher.bean.CSVAddress;
import org.endeavourhealth.propertymatcher.bean.Response;
import org.endeavourhealth.propertymatcher.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PropertymatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertymatcherApplication.class, args);
	}
}

@Component
class CommandLineAppStartupRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

	private final String url = "http://localhost:9001/addresses?verbose=true&matchthreshold=5&rangekm=&historical=true&offset=0&classificationfilter=&lon=-3.5091076&enddate=&limit=10&input=";
	
	private final RestTemplate restTemplate = new RestTemplateBuilder().build();
	
	
	public void run(String... args) throws Exception {

		logger.info("Import of csv started with command-line arguments: {} .", Arrays.toString(args));
		
		long start = System.currentTimeMillis();
		long count = 0;

		Writer writer = new BufferedWriter(new FileWriter("/media/ext/LearningHealth/output.csv"));

		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("AddressLine1", "AddressLine2",
				"AddressLine3", "AddressLine4", "County", "Postcode", "Score", "OnsAddress", "OnsPostcode", "OnsUprn", "Status"));
		
		Reader in = new FileReader("/media/ext/LearningHealth/address_extract.csv");
		
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);

		for (CSVRecord record : records) {
			
			CSVAddress csvAddress = new CSVAddress( record );
			
			Result result = getResponseFromOns( csvAddress );

			Optional<Address> topScoringAddress = result
					.getResponse()
					.getAddresses()
					.stream()
					.collect(Collectors.maxBy( Comparator.comparing( Address::getConfidenceScore ) ));
			
			Address address = topScoringAddress.orElse(new Address(false));
			
			printToCsv(csvPrinter, csvAddress, address);
			
			count++;
			
			long end = System.currentTimeMillis();
			if(count % 100 == 0) {
				logger.info("Have processed {} records in {} milliseconds", count, (end - start));
			}
		}
		
		long end = System.currentTimeMillis();
		if(count % 100 == 0) {
			logger.info("Finished!! Have processed {} records in {} milliseconds", count, (end - start));
		}
	}

	private void printToCsv(CSVPrinter csvPrinter, CSVAddress csvAddress, Address address) throws IOException {
		
		csvPrinter.printRecord(
				csvAddress.getLine1(), 
				csvAddress.getLine2(), 
				csvAddress.getLine3(), 
				csvAddress.getLine4(), 
				csvAddress.getCounty(),
				csvAddress.getPostcode(), 
				address.getConfidenceScore(), 
				address.getFormattedAddress(),
				address.getPostcode(), 
				address.getUprn(),
				address.getStatus());
		
	}

	private Result getResponseFromOns(CSVAddress csvAddress) {
		
		String q = csvAddress.getQ(); 
		
		ResponseEntity<String> stringEntity = restTemplate.getForEntity(url + q, String.class);

		Result responseEntity = restTemplate.getForObject(url + q, Result.class);
		
		return responseEntity;
	}
}
