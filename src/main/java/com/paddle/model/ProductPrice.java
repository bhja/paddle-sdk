package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor public class ProductPrice {

    private String id;

    @JsonProperty("product_id") private String productId;

    private String type;

    private String description;

    private String name;

    @JsonProperty("seller_id") private String sellerId;

    @JsonProperty("billing_cycle") private Map<String, Object> billingCycle;

    @JsonProperty("trial_period") private Map<String, Object> trialPeriod;

    @JsonProperty("unit_price") private Map<String, Object> unitPrice;

    @JsonProperty("unit_price_overrides") private List<Map<String, Object>> unitPriceOverrides;

    @JsonProperty("tax_mode") private String taxMode;

    private Map<String, Object> quantity;

    private String status;

    @JsonProperty("custom_data") private Map<String, Object> customData;

}
