package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
    private String status;
    private String amount;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("error_code")
    private String errorCode;

    @JsonProperty("captured_at")
    private LocalDateTime capturedAt;

    @JsonProperty("method_details")
    private PaymentMethod methodDetails;

    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("payment_attempt_id")
    private String paymentAttemptId;

    @JsonProperty("stored_payment_method_id")
    private String storedPaymentMethodId;
}
