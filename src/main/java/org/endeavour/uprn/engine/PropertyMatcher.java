package org.endeavour.uprn.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PropertyMatcherResult;

public interface PropertyMatcher {
	
	
	public PropertyMatcherResult match(Address address);
}
