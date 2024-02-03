package com.paddle.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.EEffectiveFrom;

public class Discount {

  private String id;
  @JsonProperty(value = "effective_from")
  private EEffectiveFrom effectiveFrom;

}
