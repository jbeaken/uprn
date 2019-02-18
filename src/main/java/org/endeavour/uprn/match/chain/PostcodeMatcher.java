package org.endeavour.uprn.match.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;

public class PostcodeMatcher implements MatchChain {
	
	private MatchChain nextChain;

	public void setNextChain(MatchChain nextChain) {
		this.nextChain = nextChain;
		
	}


	public void match(Address address, Result result) {
		// TODO Auto-generated method stub
		
	}

}
