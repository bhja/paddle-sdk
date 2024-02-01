package com.paddle.business;

import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Business;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class BusinessService extends ApiResource<Business> {

  public BusinessService(HTTPConfig config) {
    super(config);
  }

  public Business createBusiness(String customerId, BusinessCreateParams params)
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

  public Business getBusiness(String customerId, String businessId) throws PaddleException {
    HttpRequest request = httpClient().request(
        URI.create(
            String.format("%s/%s/%s/%s", baseUrl(), CUSTOMERS, customerId, BUSINESS, businessId)),
        HttpMethod.GET.name(),
        HttpRequest.BodyPublishers.noBody());
    return get(request);
  }
}
