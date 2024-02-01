package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Discount {
    private String id;
    private String status;
    private String description;

    @JsonProperty("enabled_for_checkout")
    private boolean enabledForCheckout;

    private String code;

    private DiscountType type;
    private String amount;
    @JsonProperty("currency_code")
    private String currencyCode;

    private boolean recur;
    @JsonProperty("maximum_recurring_intervals")
    private Integer maximumRecurringIntervals;
    @JsonProperty("usage_limit")
    private Integer usageLimit;

    @JsonProperty("restrict_to")
    private List<String> restrictTo;
    @JsonProperty("expires_at")
    private LocalDateTime expiresAt;

    @JsonProperty("times_used")
    private Integer timesUsed;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

}

