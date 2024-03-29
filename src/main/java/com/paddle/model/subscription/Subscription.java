package com.paddle.model.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.BillingDetails;
import com.paddle.model.BillingPeriod;
import com.paddle.model.Discount;
import com.paddle.model.IntervalPeriod;
import com.paddle.model.ScheduleChange;
import com.paddle.model.enums.ECollectionMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
  private IntervalPeriod billingCycle;

  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("next_billed_at")
  private LocalDateTime nextBilledAt;


  @JsonProperty("billing_details")
  private BillingDetails billingDetails;

  @JsonProperty("collection_mode")
  private ECollectionMode collectionMode = ECollectionMode.automatic;

  @JsonProperty("first_billed_at")
  private LocalDateTime firstBilledAt;

  @JsonProperty("scheduled_change")
  private ScheduleChange scheduleChange;

  @JsonProperty("current_billing_period")
  private BillingPeriod currentBillingPeriod;

  @JsonProperty("customer_id")
  private String customerId;
  @JsonProperty("business_id")
  private String businessId;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;

  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;

  @JsonProperty("started_at")
  private LocalDateTime startedAt;

  @JsonProperty("canceled_at")
  private LocalDateTime canceledAt;

  @JsonProperty("trial_dates")
  private BillingPeriod trialDates;

}
