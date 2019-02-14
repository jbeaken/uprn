package org.endeavour.uprn.bean;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
public class Address {

	private String postcode;
	
    private String firstName;
    private String lastName;

    private String addressLine1;
    private String addressLine2;
    private String addressLine3;

    private String city;
    private String district;
    private String postCode;	
}
