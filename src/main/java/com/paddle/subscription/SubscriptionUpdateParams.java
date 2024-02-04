package com.paddle.subscription;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.ScheduleChange;
import com.paddle.model.enums.EOnPaymentFailure;
import com.paddle.model.enums.EProrationBillingMode;
import com.paddle.model.subscription.SubscriptionUpdateItem;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
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
public class SubscriptionUpdateParams {


  private List<SubscriptionUpdateItem> items;

  @JsonProperty("customer_id")
  private String customerId;
  @JsonProperty("business_id")
  private String businessId;

  @JsonProperty("address_id")
  private String addressId;
  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("collection_mode")
  private String collectionMode;

  @JsonProperty("billing_details")
  private Map<String, Object> billingDetails;

  //Required should not be removed.
  @JsonProperty("proration_billing_mode")
  private EProrationBillingMode prorationBillingMode;

  @JsonProperty("on_payment_failure")
  private EOnPaymentFailure onPaymentFailure = EOnPaymentFailure.prevent_change;

  @JsonProperty("custom_data")
  private Map<String, Object> customData;

  //Set this to null to change the previous.
  @JsonProperty("scheduled_change")
  private ScheduleChange scheduleChange;

  @JsonProperty("next_billed_at")
  private LocalDateTime nextBillingAt;

}
