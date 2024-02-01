package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor public class UnitPrice {

    private String amount;

    @JsonProperty("currency_code") private String currencyCode;
}
