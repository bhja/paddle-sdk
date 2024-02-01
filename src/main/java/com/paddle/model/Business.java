package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Business extends PaddleBase {

  private String id;
  private String name;

  @JsonProperty("company_number")
  private String companyNumber;

  @JsonProperty("tax_identifier")
  private String taxIdentifier;

  private List<Contact> contacts;

}
