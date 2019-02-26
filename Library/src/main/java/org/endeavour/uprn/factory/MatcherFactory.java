package org.endeavour.uprn.factory;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.match.chain.MatchChain;
import org.endeavour.uprn.match.chain.PostcodeMatcher;
import org.endeavour.uprn.match.engine.AddressMatcher;
import org.endeavour.uprn.match.engine.UPRNMatcher;
import org.endeavour.uprn.preprocess.chain.PostcodePreprocessor;
import org.endeavour.uprn.preprocess.chain.PreprocessChain;
import org.endeavour.uprn.preprocess.engine.AddressPreprocessor;
import org.endeavour.uprn.preprocess.engine.UPRNPreprocessor;

public class MatcherFactory {
	
	private MatchChain m1;
	private PreprocessChain p1;

	private MatcherFactory() {
		super();
		
		this.m1 = new PostcodeMatcher();
		this.p1 = new PostcodePreprocessor();
		
//		MatchChain c2 = new PostcodeMatcher();

//		c1.setNextChain(c2);
//		c2.setNextChain(c3)
	}
	
	public static MatcherFactory build() {
		return new MatcherFactory();
	}

	public Result match(Address address) {
		
		Result result = new Result();
		
		//Process
		m1.proceed(address, result);

		//Cut short matching if preprocessor has failed
		if(result.isFailure()) {
			return result;
		}
		
		//Match
		p1.proceed(address, result);

		return result;
	}
}
