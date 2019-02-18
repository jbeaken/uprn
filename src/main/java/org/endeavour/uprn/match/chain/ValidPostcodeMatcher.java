package org.endeavour.uprn.match.chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.PropertyMatcherResultType;
import org.endeavour.uprn.match.chain.MatchChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidPostcodeMatcher implements MatchChain {

	Logger logger = LoggerFactory.getLogger(ValidPostcodeMatcher.class);

	final Pattern postcodePattern;
	
	final PropertyMatcherResultType propertyMatcherResultType = PropertyMatcherResultType.POSTCODE;

	public ValidPostcodeMatcher() {
		super();
		
		//https://regex101.com/r/eX5uW6/1
		String patternString = "^([A-PR-UWYZ](([0-9](([0-9]|[A-HJKSTUW])?)?)|([A-HK-Y][0-9]([0-9]|[ABEHMNPRVWXY])?)) ?[0-9][ABD-HJLNP-UW-Z]{2})$";

		postcodePattern = Pattern.compile(patternString);
	}

	private MatchChain nextChain;

	public void setNextChain(MatchChain nextChain) {
		this.nextChain = nextChain;
	}

	public void match(Address address, MatcherResult propertyMatcherResult) {

		String postcode = address.getPostcode();

		logger.debug("Checking for valid postcode {}", postcode);

		if (address.getPostcode() == null) {

			propertyMatcherResult.setFailure("Postcode is null", propertyMatcherResultType);

			return;
		}

		Matcher matcher = postcodePattern.matcher(postcode);
		boolean matches = matcher.matches();

		if (!matches) {
			propertyMatcherResult.setFailure("Postcode doesn't match regex", propertyMatcherResultType);
			return;
		}

		logger.debug("Postcode is valid. Continuing chain");
		
		propertyMatcherResult.setSuccess("Postcode is valid", propertyMatcherResultType);

		nextChain.match(address, propertyMatcherResult);

	}

}
