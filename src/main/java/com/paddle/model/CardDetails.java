package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor public class CardDetails {

    private String type;
    private String last4;
    @JsonProperty("expiry_year") private String expiryYear;
    @JsonProperty("expiry_month") private String expiryMonth;
    @JsonProperty("cardholder_name") private String cardHolderName;
}
