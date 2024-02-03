package com.paddle.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.subscription.SubscriptionUpdateItem;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusUpdateParams {

  @JsonProperty("effective_from")
  private String effectiveFrom;
  @JsonProperty("resume_at")
  private String resumeAt;

  @JsonProperty("items")
  private List<SubscriptionUpdateItem> items;

}
