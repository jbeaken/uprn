package org.endeavour.uprn.match.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;

public interface MatchChain {
	
	void setNextChain(MatchChain nextChain);
	
	void match(Address address, MatcherResult propertyMatcherResult);
}
