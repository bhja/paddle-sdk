package com.paddle.product;

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
@NoArgsConstructor
@AllArgsConstructor
public class ProductQueryParams extends QueryParams {

  @JsonProperty("tax_category")
  private String taxCategory;
  private String type;

  @Builder
  public ProductQueryParams(String type, String taxCategory, String after, String orderBy,
      Integer perPage,
      List<String> ids, String status, String include) {
    super(after, orderBy, perPage, status, ids, include);
    this.type = type;
    this.taxCategory = taxCategory;
  }


}
