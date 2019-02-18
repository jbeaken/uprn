package org.endeavour.uprn.preprocess.engine;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.preprocess.chain.PostcodePreprocessor;
import org.endeavour.uprn.preprocess.chain.PreprocessChain;

public class UPRNPreprocessor implements AddressPreprocessor {
	
	private PreprocessChain c1;
	
	public UPRNPreprocessor() {
		this.c1 = new PostcodePreprocessor();
//		MatchChain c2 = new PostcodeMatcher();

//		c1.setNextChain(c2);
//		c2.setNextChain(c3);
	}


	@Override
	public Result process(Address address) {
		Result result = new Result();
		
		c1.process(address, result);
		
		return result;
	}

}