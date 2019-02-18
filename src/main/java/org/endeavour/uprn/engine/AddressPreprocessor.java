package org.endeavour.uprn.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PreprocessorResult;

public interface AddressPreprocessor {
	
	
	public PreprocessorResult process(Address address);
}
