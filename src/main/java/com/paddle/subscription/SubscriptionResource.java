package com.paddle.subscription;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.PaddleResponse;
import com.paddle.model.subscription.Subscription;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SubscriptionResource extends ApiResource<Subscription> {

  private final static String ACTIVATE = "activate";
  private final static String CANCEL = "cancel";

  public SubscriptionResource(HTTPConfig config) {
    super(config);
  }

  public Subscription retrieve(String subscriptionId) throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s/%s", baseUrl(), SUBSCRIPTION, subscriptionId)),
          HttpMethod.GET.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      return get(request);
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  public Subscription updateSubscription(String subscriptionId, SubscriptionUpdateParams params)
      throws PaddleException {
    return null;
  }

  public Subscription activate(String subscriptionId) throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(
              String.format("%s/%s/%s/%s", baseUrl(), SUBSCRIPTION, subscriptionId, ACTIVATE)),
          HttpMethod.POST.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      return post(request);
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  public Subscription cancel(String subscriptionId)
      throws PaddleException {
    return cancel(subscriptionId, null);
  }

  public Subscription cancel(String subscriptionId, StatusUpdateParams params)
      throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(
              String.format("%s/%s/%s/%s", baseUrl(), SUBSCRIPTION, subscriptionId, CANCEL)),
          HttpMethod.POST.name(),
          params == null ? HttpRequest.BodyPublishers.noBody()
              : HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      return post(request);
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
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
