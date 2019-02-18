package org.endeavour.uprn.preprocess.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.PreprocessorResult;

public class PostcodeMatcher implements PreprocessChain {
	
	private PreprocessChain nextChain;

	public void setNextChain(PreprocessChain nextChain) {
		this.nextChain = nextChain;
		
	}


	public void match(Address address, PreprocessorResult preprocessorResult) {
		// TODO Auto-generated method stub
		
	}

}
