package org.endeavourhealth.propertymatcher.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ONSAddress {
	
	
	public ONSAddress() {
		this.status = "NO_MATCH";
	}
	
	//From ons match
	@JsonProperty private Double confidenceScore;
	@JsonProperty private String formattedAddress;
	@JsonProperty private String uprn;
	@JsonProperty private String classificationCode;
	
	//Local state
	private String status;
	
	@JsonProperty private Paf paf;
	@JsonProperty private Nag nag;

	public Object getPostcode() {
		if(paf != null) return paf.getPostcode();
		if(nag != null) return nag.getPostcode();
		
		return null;
	}
}
