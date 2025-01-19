package com.hahn.assessment.rabat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    @NotBlank(message = "Street address is required.")
    private String streetAddress;

    @NotBlank(message = "City is required.")
    private String city;

    @NotBlank(message = "State is required.")
    private String state;

    @NotBlank(message = "Postal code is required.")
    @Size(min = 4, max = 10, message = "Postal code must be between 4 and 10 characters.")
    private String postalCode;

    @NotBlank(message = "Country is required.")
    private String country;
}
