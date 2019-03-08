package org.endeavourhealth.propertymatcher.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String originalPostcode;
	private String line1;
	private String line2;
	private String line3;
	private String line4;
	private String county;
	private String postcode;
	
	private Integer score;
	private String onsAddress;
	
}
