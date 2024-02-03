package com.paddle.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubscriptionUpdateItem {

  @JsonProperty("price_id")
  private String priceId;
  private int quantity;

}
