package com.paddle.transaction;

import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.model.Transaction;
import java.net.http.HttpResponse;

public class TransactionResource extends ApiResource<Transaction> {

  public TransactionResource(HTTPConfig config) {
    super(config);
  }

  @Override
  protected Transaction convertResponse(HttpResponse<String> response) throws PaddleException {
    return null;
  }

  public Transaction getTransactions(String subscription) {
    return null;
  }
}
