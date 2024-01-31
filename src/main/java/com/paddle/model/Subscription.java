package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {

  private String id;
  private List<SubscriptionItem> items = new ArrayList<>();

  private String status;
  private Discount discount;

  @JsonProperty("paused_at")
  private LocalDateTime pausedAt;

  @JsonProperty("address_id")
  private String addressId;

  @JsonProperty("billing_cycle")
  private Map<String, Object> billingCycle;

  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("next_billed_at")
  private LocalDateTime nextBilledAt;

  @JsonProperty("billing_details")
  private Map<String, Object> billingDetails;

  @JsonProperty("collection_mode")
  private String collectionMode;

  @JsonProperty("first_billed_at")
  private LocalDateTime firstBilledAt;

  @JsonProperty("scheduled_change")
  private ScheduleChange scheduleChange;

  @JsonProperty("current_billing_period")
  private Map<String, LocalDateTime> currentBillingPeriod;

  @JsonProperty("customer_id")
  private String customerId;
  @JsonProperty("business_id")
  private String businessId;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;

  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;


}
