package org.endeavour.uprn.match.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;

import org.endeavour.uprn.match.chain.MatchChain;
import org.endeavour.uprn.match.chain.PostcodeMatcher;

/**
 * Entry point for the chain of responsiblity
 * 
 * @author jack
 *
 */
public class UPRNMatcher implements AddressMatcher {
	
	private MatchChain c1;
	
	public UPRNMatcher() {
		this.c1 = new PostcodeMatcher();
//		MatchChain c2 = new PostcodeMatcher();

//		c1.setNextChain(c2);
//		c2.setNextChain(c3);
	}

	public Result match(Address address) {
		
		Result result = new Result();
		
		c1.match(address, result);
		
		return result;
	}

}
