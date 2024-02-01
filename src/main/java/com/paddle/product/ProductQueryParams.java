package com.paddle.product;

import com.paddle.model.QueryParams;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductQueryParams extends QueryParams {

  //Only one value is allowed = > prices
  private String include;

}
