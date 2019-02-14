package org.endeavour.uprn.test;

import static org.assertj.core.api.Assertions.*;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.AddressPreprocessorResult;
import org.endeavour.uprn.bean.PropertyMatcherResult;
import org.endeavour.uprn.bean.UPRNAddressPreprocessor;
import org.endeavour.uprn.engine.AddressPreprocessor;
import org.endeavour.uprn.engine.PropertyMatcher;
import org.endeavour.uprn.engine.UPRNPropertyMatcher;
import org.junit.Test;


public class PropertymatcherTest {
	
	PropertyMatcher propertyMatcher = new UPRNPropertyMatcher();
	
	AddressPreprocessor addressPreprocessor = new UPRNAddressPreprocessor();
	
    @Test
    public void testEmptyAddress() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( null )
    		.build();
    	
    	AddressPreprocessorResult addressPreprocessorResult = addressPreprocessor.process(address);
    	
    	PropertyMatcherResult propertyMatcherResult = propertyMatcher.match(address);
    	
    	assertThat(propertyMatcherResult.getMatched()).isFalse();
    }
}
