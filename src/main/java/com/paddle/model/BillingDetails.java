package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillingDetails {

  @JsonProperty("enable_checkout")
  private boolean enableCheckout;

  @JsonProperty("purchase_order_number")
  private String purchaseOrderNumber;

  @JsonProperty("additional_information")
  private String additionalInformation;

  @JsonProperty("payment_terms")
  private PaymentTerm paymentTerms;

}
