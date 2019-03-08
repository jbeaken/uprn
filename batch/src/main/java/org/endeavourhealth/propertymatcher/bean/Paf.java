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
}
