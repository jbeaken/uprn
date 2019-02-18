package org.endeavour.uprn.match.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;

public class PostcodeMatcher implements MatchChain {
	
	private MatchChain nextChain;

	public void setNextChain(MatchChain nextChain) {
		this.nextChain = nextChain;
		
	}


	public void match(Address address, MatcherResult propertyMatcherResult) {
		// TODO Auto-generated method stub
		
	}

}
