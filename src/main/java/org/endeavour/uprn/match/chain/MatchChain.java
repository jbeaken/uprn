package org.endeavour.uprn.match.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.bean.Result;

public interface MatchChain {
	
	void setNextChain(MatchChain nextChain);
	
	void match(Address address, Result result);
	
	default Phase getPhase() {
		return Phase.MATCHING;
	}
}
