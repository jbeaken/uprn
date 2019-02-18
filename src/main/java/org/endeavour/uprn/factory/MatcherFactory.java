package org.endeavour.uprn.factory;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.match.engine.AddressMatcher;
import org.endeavour.uprn.match.engine.UPRNMatcher;
import org.endeavour.uprn.preprocess.engine.AddressPreprocessor;
import org.endeavour.uprn.preprocess.engine.UPRNPreprocessor;

public class MatcherFactory {

	AddressMatcher addressMatcher = new UPRNMatcher();

	AddressPreprocessor uprnPreprocessor = new UPRNPreprocessor();
	
	private MatcherFactory() {
		super();
	}
	
	public static MatcherFactory build() {
		return new MatcherFactory();
	}

	public Result match(Address address) {

		Result result = uprnPreprocessor.process(address);

		//Cut short matching if preprocessor has failed
		if(result.isFailure()) {
			return result;
		}
		
		result = addressMatcher.match(address);

		return result;
	}
}
