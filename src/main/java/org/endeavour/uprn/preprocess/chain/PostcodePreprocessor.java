package org.endeavour.uprn.preprocess.chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.bean.ResultType;
import org.endeavour.uprn.match.chain.MatchChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostcodePreprocessor implements PreprocessChain {

	Logger logger = LoggerFactory.getLogger(PostcodePreprocessor.class);
	
	private PreprocessChain nextChain;

	final Pattern postcodePattern;
	
	final ResultType propertyMatcherResultType = ResultType.POSTCODE;

	public PostcodePreprocessor() {
		super();
		
		//https://regex101.com/r/eX5uW6/1
		String patternString = "^([A-PR-UWYZ](([0-9](([0-9]|[A-HJKSTUW])?)?)|([A-HK-Y][0-9]([0-9]|[ABEHMNPRVWXY])?)) ?[0-9][ABD-HJLNP-UW-Z]{2})$";

		postcodePattern = Pattern.compile(patternString);
	}


	public void setNextChain(PreprocessChain nextChain) {
		this.nextChain = nextChain;
	}

	public void process(Address address, Result result) {

		String postcode = address.getPostcode();

		logger.debug("Checking for valid postcode {}", postcode);

		if (address.getPostcode() == null) {

			result.setFailure("Postcode is null", propertyMatcherResultType, getPhase());

			return;
		}

		Matcher matcher = postcodePattern.matcher(postcode);
		boolean matches = matcher.matches();

		if (!matches) {
			result.setFailure("Postcode doesn't match regex", propertyMatcherResultType, getPhase());
			return;
		}

		logger.debug("Postcode is valid. Continuing chain");
		
		if(nextChain != null) {
			nextChain.process(address, result);
		}

	}

}
