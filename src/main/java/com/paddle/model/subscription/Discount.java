package com.paddle.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.enums.EEffectiveFrom;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Discount {

  private String id;
  @JsonProperty(value = "effective_from")
  private EEffectiveFrom effectiveFrom;

}
