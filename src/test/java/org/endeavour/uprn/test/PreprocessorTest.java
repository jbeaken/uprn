package org.endeavour.uprn.test;

import static org.assertj.core.api.Assertions.*;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.PreprocessorResult;
import org.endeavour.uprn.bean.MatcherResult;
import org.endeavour.uprn.bean.UPRNPreprocessor;
import org.endeavour.uprn.engine.AddressPreprocessor;
import org.endeavour.uprn.match.engine.PropertyMatcher;
import org.endeavour.uprn.match.engine.UPRNMatcher;
import org.junit.Test;


public class PreprocessorTest {
	
	PropertyMatcher propertyMatcher = new UPRNMatcher();
	
	AddressPreprocessor uprnPreprocessor = new UPRNPreprocessor();
	
    @Test
    public void testNullPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( null )
    		.build();
    	
    	PreprocessorResult addressPreprocessorResult = uprnPreprocessor.process(address);
    	
    	MatcherResult propertyMatcherResult = propertyMatcher.match(address);
    	
    	assertThat(propertyMatcherResult.getMatched()).isFalse();
    	
    	assertThat(propertyMatcherResult.getMessage()).isEqualTo("Postcode is null");
    }
    
    @Test
    public void testValidPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( "E2 6HL" )
    		.build();
    	
    	PreprocessorResult addressPreprocessorResult = uprnPreprocessor.process(address);
    	
    	MatcherResult propertyMatcherResult = propertyMatcher.match(address);
    	
    	assertThat(propertyMatcherResult.getMatched()).isTrue();
    	
    	assertThat(propertyMatcherResult.getMessage()).isEqualTo("Postcode is valid");
    }    
    
    @Test
    public void testInvalidPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( "EE 6HL" )
    		.build();
    	
    	PreprocessorResult addressPreprocessorResult = addressPreprocessor.process(address);
    	
    	MatcherResult propertyMatcherResult = propertyMatcher.match(address);
    	
    	assertThat(propertyMatcherResult.getMatched()).isFalse();
    	
    	assertThat(propertyMatcherResult.getMessage()).isEqualTo("Postcode doesn't match regex");
    }     
}
