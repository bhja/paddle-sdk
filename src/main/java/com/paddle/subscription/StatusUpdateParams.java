package com.paddle.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.subscription.SubscriptionUpdateItem;
import java.util.List;

public class StatusUpdateParams {

  @JsonProperty("effective_from")
  private String effectiveFrom;
  @JsonProperty("resume_at")
  private String resumeAt;

  @JsonProperty("items")
  private List<SubscriptionUpdateItem> items;

}
