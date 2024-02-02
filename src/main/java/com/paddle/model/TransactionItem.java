package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionItem {

  private Price price;

  @JsonProperty("price_id")
  private String priceId;

  private String quantity;
  private Map<String, Object> proration;
}
