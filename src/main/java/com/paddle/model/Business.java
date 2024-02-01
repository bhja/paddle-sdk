package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Business {
    private String id;
    private String name;

    @JsonProperty("company_number")
    private String companyNumber;

    @JsonProperty("tax_identifier")
    private String taxIdentifier;

    private String status;


    private List<Contact> contacts;

    private Map<String, Object> customData;

}
