package org.endeavour.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PropertyMatcherResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidPostcodeMatcher implements MatchChain {
	
	Logger logger = LoggerFactory.getLogger(ValidPostcodeMatcher.class);
	
	private MatchChain nextChain;

	public void setNextChain(MatchChain nextChain) {
		this.nextChain = nextChain;
	}


	public void match(Address address, PropertyMatcherResult propertyMatcherResult) {
		
		logger.debug("Checking for valid postcode {}", address.getPostcode());
		
		if(address.getPostcode() == null) {
			
			logger.debug("Postcode is null, false match");
			
			propertyMatcherResult.setMatched(false);
			
			return;
		}
		
		logger.debug("Postcode is valid. Continuing chain");
		
		nextChain.match(address, propertyMatcherResult);
		
	}

}
