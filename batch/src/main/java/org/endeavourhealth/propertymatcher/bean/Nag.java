package org.endeavourhealth.propertymatcher.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Nag {
	@JsonProperty private String postcode;
	@JsonProperty private String postTown;
	
	public Nag() {
		super();
	}
	
	public Nag(String postcode, String postTown) {
		this();
		this.postcode = postcode;
		this.postTown = postTown;
	}
}
