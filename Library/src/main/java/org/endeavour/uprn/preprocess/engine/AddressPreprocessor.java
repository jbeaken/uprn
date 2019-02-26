package org.endeavour.uprn.preprocess.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PreprocessorResult;
import org.endeavour.uprn.bean.Result;

public interface AddressPreprocessor {
	
	
	public Result process(Address address);
}
