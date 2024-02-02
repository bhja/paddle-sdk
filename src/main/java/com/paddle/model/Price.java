package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {

  private String id;

  @JsonProperty("product_id")
  private String productId;

  private String type;

  private String description;

  private String name;

  @JsonProperty("seller_id")
  private String sellerId;

  @JsonProperty("billing_cycle")
  private Map<String, Object> billingCycle;

  @JsonProperty("trial_period")
  private Map<String, Object> trialPeriod;

  @JsonProperty("unit_price")
  private Map<String, Object> unitPrice;

  @JsonProperty("unit_price_overrides")
  private List<Map<String, Object>> unitPriceOverrides;

  @JsonProperty("tax_mode")
  private String taxMode;

  private Quantity quantity;

  private String status;

  @JsonProperty("custom_data")
  private Map<String, Object> customData;

}
