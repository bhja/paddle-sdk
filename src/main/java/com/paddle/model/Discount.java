package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Discount extends PaddleBase {

  private String id;

  private String description;

  @JsonProperty("enabled_for_checkout")
  private boolean enabledForCheckout;

  private String code;

  private DiscountType type;
  private String amount;
  @JsonProperty("currency_code")
  private String currencyCode;

  private boolean recur;
  @JsonProperty("maximum_recurring_intervals")
  private Integer maximumRecurringIntervals;
  @JsonProperty("usage_limit")
  private Integer usageLimit;

  @JsonProperty("restrict_to")
  private List<String> restrictTo;
  @JsonProperty("expires_at")
  private LocalDateTime expiresAt;
  @JsonProperty("times_used")
  private Integer timesUsed;

}

