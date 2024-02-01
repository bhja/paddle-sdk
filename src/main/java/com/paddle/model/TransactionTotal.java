package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor public class TransactionTotal extends Total {

    private String credit;
    private String balance;
    private String earnings;

    @JsonProperty("grand_total") private String grandTotal;
    @JsonProperty("currency_code") private String currencyCode;
    @JsonProperty("credit_to_balance") private String creditToBalance;
    @JsonProperty("exchange_rate") private String exchangeRate;

}
