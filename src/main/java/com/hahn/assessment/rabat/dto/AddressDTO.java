package com.hahn.assessment.rabat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String streetAddress;

    private String city;

    private String state;

    private String postalCode;

    private String country;
}
