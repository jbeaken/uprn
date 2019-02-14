package org.endeavour.uprn.engine;

import org.endeavour.chain.MatchChain;
import org.endeavour.chain.PostcodeMatcher;
import org.endeavour.chain.ValidPostcodeMatcher;
import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PropertyMatcherResult;

public class UPRNPropertyMatcher implements PropertyMatcher {
	
	private MatchChain c1;
	
	public UPRNPropertyMatcher() {
		this.c1 = new ValidPostcodeMatcher();
		MatchChain c2 = new PostcodeMatcher();

		c1.setNextChain(c2);
//		c2.setNextChain(c3);
	}

	public PropertyMatcherResult match(Address address) {
		
		preProcessAddress(address);
		
		PropertyMatcherResult propertyMatcherResult = new PropertyMatcherResult();
		
		c1.match(address, propertyMatcherResult);
		
		return propertyMatcherResult;
	}

	private void preProcessAddress(Address address) {
		// TODO Auto-generated method stub
		
	}

}
