package com.paddle.subscription;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.model.PaddleResponse;
import com.paddle.model.Subscription;
import java.net.http.HttpResponse;

public class SubscriptionResource extends ApiResource<Subscription> {

  public SubscriptionResource(HTTPConfig config) {
    super(config);
  }

  public Subscription retrieve(String subscriptionId) throws PaddleException {
    return null;
  }

  public Subscription updateSubscription() throws PaddleException {
    return null;
  }

  public Subscription activate(String subscriptionId) throws PaddleException {
    return null;
  }


  public Subscription modify(String subscriptionId) throws PaddleException {
    return null;
  }

  @Override
  protected Subscription convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Subscription> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }

}
