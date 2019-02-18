package org.endeavour.uprn.match.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;

import org.endeavour.uprn.match.chain.MatchChain;
import org.endeavour.uprn.match.chain.PostcodeMatcher;
import org.endeavour.uprn.match.chain.ValidPostcodeMatcher;

public class UPRNMatcher implements PropertyMatcher {
	
	private MatchChain c1;
	
	public UPRNMatcher() {
		this.c1 = new ValidPostcodeMatcher();
		MatchChain c2 = new PostcodeMatcher();

		c1.setNextChain(c2);
//		c2.setNextChain(c3);
	}

	public MatcherResult match(Address address) {
		
		preProcessAddress(address);
		
		MatcherResult propertyMatcherResult = new MatcherResult();
		
		c1.match(address, propertyMatcherResult);
		
		return propertyMatcherResult;
	}

	private void preProcessAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

}
