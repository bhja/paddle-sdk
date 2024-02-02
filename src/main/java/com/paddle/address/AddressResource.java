package com.paddle.address;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Address;
import com.paddle.model.PaddleResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddressResource extends ApiResource<Address> {

  private static final String ADDRESSES = "addresses";

  public AddressResource(HTTPConfig config) {
    super(config);
  }

  public Address retrieve(String customerId, String addressId) throws PaddleException {
    HttpRequest request = httpClient().request(
        URI.create(
            String.format("%s/%s/%s/%s", baseUrl(), CUSTOMERS, customerId, ADDRESSES, addressId)),
        HttpMethod.GET.name(),
        HttpRequest.BodyPublishers.noBody());
    return get(request);
  }

  public Address create(String customerId, AddressCreateParams params)
      throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s/%s", baseUrl(), CUSTOMERS, customerId, ADDRESSES)),
          HttpMethod.POST.name(),
          HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
      return create(request);
    } catch (IOException e) {
      throw new PaddleException(e);
    }
  }

  @Override
  protected Address convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Address> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }
}
