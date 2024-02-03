package com.paddle.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.Item;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubscriptionItem extends Item {

  private boolean recurring;

  @JsonProperty("trial_dates")
  private Map<String, LocalDateTime> trialDates;

  @JsonProperty("next_billed_at")
  private LocalDateTime nextBilledAt;
  @JsonProperty("previously_billed_at")
  private LocalDateTime previouslyBilledAt;

}
