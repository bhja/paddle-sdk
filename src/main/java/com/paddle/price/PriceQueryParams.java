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
public class PriceQueryParams extends QueryParams {

  @JsonProperty("product_id")
  private String productId;

  private Boolean recurring;

  private String type;

  @Builder
  public PriceQueryParams(String productId, Boolean recurring, String type, String after,
      String orderBy, Integer perPage, String status,
      List<String> id, List<String> include) {
    super(after, orderBy, perPage, status, id, include);
    this.productId = productId;
    this.recurring = recurring;
    this.type = type;

  }
}
