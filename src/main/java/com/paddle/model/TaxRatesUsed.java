package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaxRatesUsed {

    private Total total;

    @JsonProperty("tax_rate")
    private String taxRate;
}
