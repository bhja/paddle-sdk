package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitPriceOverrides extends UnitPrice {

  @JsonProperty("country_codes")
  private List<String> countryCodes;
}
