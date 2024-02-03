package com.paddle.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paddle.model.LineItem;
import com.paddle.model.TaxRatesUsed;
import java.util.List;

public class TransactionDetail {

  @JsonProperty("payout_totals")
  private TransactionTotal payoutTotals;

  @JsonProperty("adjusted_totals")
  private TransactionTotal adjustedTotals;

  @JsonProperty("tax_rates_used")
  private List<TaxRatesUsed> taxRatesUsed;

  @JsonProperty("totals")
  private TransactionTotal totals;

  @JsonProperty("line_items")
  private List<LineItem> lineItems;

}
