package org.endeavour.uprn.bean;

public enum PropertyMatcherResultType {
	POSTCODE("Postcode");
	
	
	String displayName;
	
	PropertyMatcherResultType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}

}
