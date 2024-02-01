package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor public class Business extends PaddleBase {

    private String id;
    private String name;

    @JsonProperty("company_number") private String companyNumber;

    @JsonProperty("tax_identifier") private String taxIdentifier;

    private List<Contact> contacts;

}
