package org.endeavour.uprn.preprocess.chain;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.bean.ResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CityPreprocessor extends PreprocessChain {

	Logger logger = LoggerFactory.getLogger(CityPreprocessor.class);
	
	final ResultType resultType = ResultType.CITY;


	public void proceed(Address address, Result result) {

		String city = address.getCity();

		logger.debug("Checking for valid city {}", city);

		if (city == null) {

			result.setFailure("City is null", resultType, getPhase());

			return;
		}

		logger.debug("City is valid. Continuing chain");
		
		next(address, result);

	}
}
