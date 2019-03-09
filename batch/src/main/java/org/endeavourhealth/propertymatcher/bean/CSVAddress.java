package org.endeavourhealth.propertymatcher.bean;

import org.apache.commons.csv.CSVRecord;

import lombok.Data;

@Data
public class CSVAddress {
	public CSVAddress(CSVRecord record) {
		this();
		this.line1 = record.get("AddressLine1");
		this.line2 = record.get("AddressLine2");
		this.line3 = record.get("AddressLine3");
		this.line4 = record.get("AddressLine4");
		this.county = record.get("County");
		this.postcode = record.get("Postcode");
		this.psuedoPersonId = record.get("PersonPseudoId");
		this.orgPostcode = record.get("OrgPostcode");


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
