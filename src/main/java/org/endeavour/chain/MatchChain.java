package org.endeavour.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PropertyMatcherResult;

public interface MatchChain {
	
	void setNextChain(MatchChain nextChain);
	
	void match(Address address, PropertyMatcherResult propertyMatcherResult);
}
