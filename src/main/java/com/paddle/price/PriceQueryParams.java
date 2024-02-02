package com.paddle.price;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.QueryParams;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceQueryParams extends QueryParams {

  @JsonProperty("product_id")
  private List<String> productId;

  private boolean recurring;

  private String type;
}