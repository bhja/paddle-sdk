package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class LineItem
        extends Item {
    private Map<String, Object> proration;
    private String id;
    private Total totals;
    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("unit_totals")
    private Total unitTotal;

    @JsonProperty("price_id")
    private String priceId;


}
