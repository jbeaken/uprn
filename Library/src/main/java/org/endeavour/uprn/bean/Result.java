package org.endeavour.uprn.bean;

import java.util.function.IntPredicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class Result {
	
	@ToString.Exclude
	Logger logger = LoggerFactory.getLogger(MatcherResult.class);
	
	private String message;
	
	private ResultType type;
	
	private Boolean isFailure = false;
	
	private Phase phase;
	
	protected void set(String message, ResultType type, Phase phase) {
		this.type = type;
		this.message = message;
		this.phase = phase;
		
		logger.debug(this.toString());
	}
	
	public void setFailure(String message, ResultType type, Phase phase) {
		
		this.isFailure = true;
		
		set(message, type, phase);
	}
	
	public void setSuccess(String message, ResultType type, Phase phase) {
		
		this.isFailure = false;
		
		set(message, type, phase);
	}

	public boolean isFailure() {
		return isFailure;
	}

	public boolean isSuccess() {
		return !isFailure;
	}


}
