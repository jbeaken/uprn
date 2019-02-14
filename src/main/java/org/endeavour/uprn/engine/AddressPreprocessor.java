package org.endeavour.uprn.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.AddressPreprocessorResult;

public interface AddressPreprocessor {
	
	
	public AddressPreprocessorResult process(Address address);
}
