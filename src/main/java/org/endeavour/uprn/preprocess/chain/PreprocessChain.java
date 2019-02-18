package org.endeavour.uprn.preprocess.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.bean.Result;

public interface PreprocessChain {
	
	void setNextChain(PreprocessChain nextChain);
	
	void process(Address address, Result preprocessorResult);
	
	default Phase getPhase() {
		return Phase.PREPROCESSING;
	}
}
