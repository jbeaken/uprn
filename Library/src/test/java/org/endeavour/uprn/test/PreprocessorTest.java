package org.endeavour.uprn.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.endeavour.uprn.bean.Address;
import org.endeavour.uprn.bean.Phase;
import org.endeavour.uprn.bean.Result;
import org.endeavour.uprn.bean.ResultType;

import org.endeavour.uprn.factory.MatcherFactory;

import org.junit.Before;
import org.junit.Test;


public class PreprocessorTest {
	
	MatcherFactory matcherFactory;
	
	@Before
	public void init() {
		matcherFactory = MatcherFactory.build();
	}
	
    @Test
    public void testNullPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( null )
    		.build();
    	
    	Result result = matcherFactory.match(address);
    	
    	assertThat(result.isFailure()).isTrue();
    	assertThat(result.isSuccess()).isFalse();
    	assertThat(result.getPhase()).isEqualTo( Phase.PREPROCESSING );
    	
    	assertThat(result.getType()).isEqualTo(ResultType.POSTCODE);
    	assertThat(result.getMessage()).isEqualTo("Postcode is null");
    }
    
    @Test
    public void testValidPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( "E2 6HL" )
    		.build();
    	
    	Result result = matcherFactory.match(address);
    	
    	assertThat(result.isSuccess()).isTrue();
    	assertThat(result.isFailure()).isFalse();
    	
//    	assertThat(result.getMessage()).isEqualTo("Postcode is valid");
    }    
    
    @Test
    public void testInvalidPostocde() {
    	
    	Address address = Address.builder()
    		.addressLine1("address1")
    		.postcode( "EE 6HL" )
    		.build();
    	
    	Result result = matcherFactory.match(address);
    	
    	assertThat(result.isFailure()).isTrue();
    	assertThat(result.isSuccess()).isFalse();
    	assertThat(result.getPhase()).isEqualTo( Phase.PREPROCESSING );
    	
    	assertThat(result.getMessage()).isEqualTo("Postcode doesn't match regex");
    }     
}

