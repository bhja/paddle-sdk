package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdjustedTotals {
    private String fee;
    private String tax;
    private String total;
    private String earnings;
    private String subtotal;
    @JsonProperty("grand_total")
    private String grandTotal;
    @JsonProperty("currency_code")
    private String currencyCode;
}
