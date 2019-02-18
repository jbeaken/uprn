package org.endeavour.uprn.bean;

public enum Phase {
	
	MATCHING("Matching"), PREPROCESSING("Preprocessing");
	
	String displayName;
	
	Phase(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
