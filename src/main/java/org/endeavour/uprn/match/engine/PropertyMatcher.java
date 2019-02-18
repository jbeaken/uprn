package org.endeavour.uprn.match.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;

public interface PropertyMatcher {
	
	public MatcherResult match(Address address);
}
