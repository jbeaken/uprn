package org.endeavourhealth.propertymatcher.bean;

import org.apache.commons.csv.CSVRecord;

import lombok.Data;

@Data
public class CSVAddress {

	public static CSVAddress getUnmatchedCSVAddress(CSVRecord record) {
		CSVAddress address = new CSVAddress();
		address.line1 = record.get("AddressLine1");
		address.line2 = record.get("AddressLine2");
		address.line3 = record.get("AddressLine3");
		address.line4 = record.get("AddressLine4");
		address.county = record.get("County");
		address.postcode = record.get("Postcode");
		address.psuedoPersonId = record.get("PersonPseudoId");

		return address;
	}

	public static CSVAddress getDiscoveryCSVAddress(CSVRecord record) {
		CSVAddress address = new CSVAddress();
		address.line1 = record.get("AddressLine1");
		address.line2 = record.get("AddressLine2");
		address.line3 = record.get("AddressLine3");
		address.line4 = record.get("AddressLine4");
		address.county = record.get("County");
		address.postcode = record.get("Postcode");
		address.psuedoPersonId = record.get("PersonPseudoId");
		address.orgPostcode = record.get("OrgPostcode");

		return address;
	}

	public static CSVAddress getMumpsCSVAddress(CSVRecord record) {

		try {
			CSVAddress address = new CSVAddress();

			String discoveryAddress = record.get("Discovery address");

			String[] discoveryAddressParts = discoveryAddress.split(",");

			address.line1 = discoveryAddressParts[0];
			address.line2 = discoveryAddressParts[1];
			address.line3 = discoveryAddressParts.length > 2 ? discoveryAddressParts[2] : "";
			address.line4 = discoveryAddressParts.length > 3 ? discoveryAddressParts[3] : "";
			address.county = discoveryAddressParts.length > 4 ? discoveryAddressParts[4] : "";
			address.postcode = discoveryAddressParts.length > 5 ? discoveryAddressParts[5] : "";

			address.mumpsId = Long.valueOf(record.get("ID"));
			address.mumpsAlgorithum = record.get("Algorithm");
			address.mumpsQualifier = record.get("Qualifier");
			address.mumpsTable = record.get("Table");
			address.mumpsKey = record.get("Key");
			address.mumpsUprn = record.get("Match");
//		address.mumpsStatus = record.get("Status");
			address.mumpsAbpAddress = record.get("APB address");

			return address;

		} catch(Exception e) {
			System.out.println( record );
			throw e;
		}
	}
	
	private  CSVAddress() {
		super();
	}
	
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private String county;
	private String postcode;

	private String psuedoPersonId;
	private String orgPostcode;


	private Long mumpsId;
	private String mumpsAlgorithum;
	private String mumpsQualifier;
	private String mumpsTable;
	private String mumpsKey;
	private String mumpsUprn; //Match
	private String mumpsStatus;
	private String mumpsAbpAddress;


	public String getQ() {
		return line1 + " " + line2 + " " + line3 + " " + line4 + " " + county + " " + postcode;
	}
}
