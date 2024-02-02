package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryParams {

  private String after;
  @JsonProperty("order_by")
  private String orderBy;  //?order_by=id[ASC]

  @JsonProperty("per_page")
  private Integer perPage;

  //active or archived are the only status allowed.
  private String status;

  private List<String> id;

  private List<String> include;


}
