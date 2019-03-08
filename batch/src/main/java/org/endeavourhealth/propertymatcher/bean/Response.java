package org.endeavourhealth.propertymatcher.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Response {

	public Response() {
		super();
	}

	@JsonProperty
	private List<ONSAddress> addresses;
}
