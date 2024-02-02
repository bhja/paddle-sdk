package com.paddle.price;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.PaddleResponse;
import com.paddle.model.Price;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class PriceResource extends ApiResource<Price> {

  public PriceResource(HTTPConfig config) {
    super(config);
  }

  public List<Price> list(PriceQueryParams params) throws PaddleException {
    try {
      Map<String, Object> map = convertToMap(params);
      URI uri;
      if (map != null && !map.isEmpty()) {
        uri = httpClient().queryParameters(String.format("%s/%s", baseUrl(), PRICES), map);
      } else {
        uri = URI.create(String.format("%s/%s", baseUrl(), PRICES));
      }
      HttpRequest request = httpClient().request(uri,

          HttpMethod.GET.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        PaddleResponse<List<Price>> prices = getObjectMapper().readValue(response.body(),
            new TypeReference<>() {
            });
        return prices.getData();
      } else {
        throw new PaddleClientException(response.body(), response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  public Price getPrice(String priceId) {
    return null;
  }

  public Price createPrice(String productId, PriceCreateParams params) {
    return null;
  }

  public Price updatePrice(String priceId, PriceUpdateParams params) {
    return null;
  }

  @Override
  protected Price convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Price> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }
}
