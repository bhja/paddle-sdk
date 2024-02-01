package com.paddle.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.Contact;

import java.util.List;
import java.util.Map;

public class BusinessCreateParams {
    private String name;

    @JsonProperty("company_number")
    private String companyNumber;

    @JsonProperty("tax_identifier")
    private String taxIdentifier;

    private List<Contact> contacts;

    @JsonProperty("custom_data")
    private Map<String,Object> customData;
}
