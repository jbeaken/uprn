package org.endeavour.uprn.bean;

public enum ResultType {
	POSTCODE("Postcode"), CITY("City");
	
	
	String displayName;
	
	ResultType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
