package com.paddle.customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Customer;
import com.paddle.model.PaddleResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Customer related handler for Paddle
 */

public class CustomerResource extends ApiResource<Customer> {

  public CustomerResource(HTTPConfig config) {
    super(config);
  }

  @Override
  protected Customer convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Customer> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }

  /**
   * Creates the customer.Returns 409 if already exists.
   *
   * @param params
   * @return {@link Customer}
   * @throws PaddleException
   */
  public Customer createCustomer(CustomerCreateParams params) throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s", baseUrl(), CUSTOMERS)), HttpMethod.POST.name(),
          HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
      return create(request);
    } catch (IOException e) {
      throw new PaddleException(e);
    }
  }

  public Customer retrieve(String customerId) throws PaddleException {
    HttpRequest request = httpClient().request(
        URI.create(String.format("%s/%s/%s", baseUrl(), CUSTOMERS, customerId)),
        HttpMethod.GET.name(), HttpRequest.BodyPublishers.noBody());
    return get(request);

  }
}
