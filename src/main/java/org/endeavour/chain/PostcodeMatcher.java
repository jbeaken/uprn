package org.endeavour.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PropertyMatcherResult;

public class PostcodeMatcher implements MatchChain {
	
	private MatchChain nextChain;

	public void setNextChain(MatchChain nextChain) {
		this.nextChain = nextChain;
		
	}


	public void match(Address address, PropertyMatcherResult propertyMatcherResult) {
		// TODO Auto-generated method stub
		
	}

}
