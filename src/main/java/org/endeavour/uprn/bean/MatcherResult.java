package org.endeavour.uprn.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder 
@ToString
@NoArgsConstructor 
@AllArgsConstructor
public class MatcherResult {
	
	private Boolean matched;
	
	private String message;
	
	private PropertyMatcherResultType type;
	
	@ToString.Exclude
	Logger logger = LoggerFactory.getLogger(MatcherResult.class);

	public void setFailure(String message, PropertyMatcherResultType type) {
		this.matched = false;
		this.type = type;
		this.message = message;
		
		logger.debug(this.toString());
	}
	
	public void setSuccess(String message, PropertyMatcherResultType type) {
		this.matched = true;
		this.type = type;
		this.message = message;
		
		logger.debug(this.toString());
	}	

}
