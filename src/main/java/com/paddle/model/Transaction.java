package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Transaction {

  private String id;
  private List<TransactionItem> items;
  private String origin;
  private String status;
  private TransactionDetail details;
  private List<Payment> payments;
  @JsonProperty("subscription_id")
  private String subscriptionId;

  @JsonProperty("collection_mode")
  private String collectionMode;
  @JsonProperty("billing_details")
  private Map<String, Object> billingDetails;
  @JsonProperty("discount_id")
  private String discountId;

  @JsonProperty("customer_id")
  private String customerId;
  @JsonProperty("currency_code")
  private String currencyCode;

  @JsonProperty("business_id")
  private String businessId;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;
  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;

  @JsonProperty("invoice_id")
  private String invoiceId;
  @JsonProperty("billed_at")
  private LocalDateTime billedAt;

}
