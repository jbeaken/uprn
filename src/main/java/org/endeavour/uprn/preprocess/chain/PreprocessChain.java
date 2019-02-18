package org.endeavour.uprn.preprocess.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PreprocessorResult;

public interface PreprocessChain {
	
	void setNextChain(PreprocessChain nextChain);
	
	void match(Address address, PreprocessorResult preprocessorResult);
}
