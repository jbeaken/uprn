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



	public String getQ() {
		return line1 + " " + line2 + " " + line3 + " " + line4 + " " + county + " " + postcode;
	}
}
