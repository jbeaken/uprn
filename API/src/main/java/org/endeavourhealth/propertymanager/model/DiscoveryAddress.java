package org.endeavourhealth.propertymanager.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name="address")
public class DiscoveryAddress {

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

    private String onsAddress;
    private Integer score;
}
