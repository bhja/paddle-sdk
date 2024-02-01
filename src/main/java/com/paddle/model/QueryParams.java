package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
public class QueryParams {

  private String after;
  @JsonProperty("order_by")
  private String orderBy;  //?order_by=id[ASC]

  @JsonProperty("per_page")
  private Integer perPage;

}
