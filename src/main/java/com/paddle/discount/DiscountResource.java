package com.paddle.discount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Discount;
import com.paddle.model.PaddleResponse;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class DiscountResource extends ApiResource<Discount> {

  public DiscountResource(HTTPConfig config) {
    super(config);
  }

  public List<Discount> list() throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s", baseUrl(), DISCOUNT)), HttpMethod.GET.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        PaddleResponse<List<Discount>> discounts = getObjectMapper().readValue(response.body(),
            new TypeReference<>() {
            });
        return discounts.getData();
      } else {
        throw new PaddleClientException(response.body(), response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  @Override
  protected Discount convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Discount> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }

}
