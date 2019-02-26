package org.endeavour.uprn.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.preprocess.chain.PreprocessChain;

public interface Chain {
		
		void setNextChain(PreprocessChain nextChain);
		
		void proceed(Address address, Result result);
		
		Phase getPhase();
}
