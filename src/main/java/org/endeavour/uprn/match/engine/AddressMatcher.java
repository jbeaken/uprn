package org.endeavour.uprn.match.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.Result;

public interface AddressMatcher {
	
	public Result match(Address address);
}
