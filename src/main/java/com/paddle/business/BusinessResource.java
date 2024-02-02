package com.paddle.business;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Business;
import com.paddle.model.PaddleResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BusinessResource extends ApiResource<Business> {

  public BusinessResource(HTTPConfig config) {
    super(config);
  }

  public Business create(String customerId, BusinessCreateParams params)
      throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s/%s", baseUrl(), CUSTOMERS, customerId, BUSINESS)),
          HttpMethod.POST.name(),
          HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
      return create(request);
    } catch (IOException e) {
      throw new PaddleException(e);
    }
  }

  public Business retrieve(String customerId, String businessId) throws PaddleException {
    HttpRequest request = httpClient().request(
        URI.create(
            String.format("%s/%s/%s/%s", baseUrl(), CUSTOMERS, customerId, BUSINESS, businessId)),
        HttpMethod.GET.name(),
        HttpRequest.BodyPublishers.noBody());
    return get(request);
  }

  @Override
  protected Business convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Business> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }
}
