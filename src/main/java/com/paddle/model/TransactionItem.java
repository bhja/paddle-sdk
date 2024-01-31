package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class TransactionItem {

  private ProductPrice price;

  @JsonProperty("price_id")
  private String priceId;

  private String quantity;
  private Map<String, Object> proration;
}
