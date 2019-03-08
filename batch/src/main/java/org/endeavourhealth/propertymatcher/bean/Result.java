package org.endeavourhealth.propertymatcher.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Result {
	
	public Result() {
		super();
	}

	@JsonProperty
	private String apiVersion;
	
	@JsonProperty
	private String dataVersion;
	
	@JsonProperty
	private Response response;
}
