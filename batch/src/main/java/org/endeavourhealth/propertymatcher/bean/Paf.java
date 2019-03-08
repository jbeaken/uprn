package org.endeavourhealth.propertymatcher.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Paf {
	@JsonProperty private String postcode;
	@JsonProperty private String postTown;
	
	public Paf() {
		super();
	}
	
	public Paf(String postcode, String postTown) {
		this();
		this.postcode = postcode;
		this.postTown = postTown;
	}
}
