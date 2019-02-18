package org.endeavour.uprn.bean;

public enum ResultType {
	POSTCODE("Postcode");
	
	
	String displayName;
	
	ResultType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
