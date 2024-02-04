package com.paddle.product;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.PaddleResponse;
import com.paddle.model.Product;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

/**
 * Paddle products service.
 */
public class ProductResource extends ApiResource<Product> {

  public ProductResource(HTTPConfig config) {
    super(config);
  }

  public Product create(ProductCreateParams params) throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s", baseUrl(), PRODUCTS)), HttpMethod.POST.name(),
          HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
      return create(request);
    } catch (IOException e) {
      throw new PaddleException(e);
    }
  }

  public List<Product> list() throws PaddleException {
    return list(null);
  }

  public List<Product> list(ProductQueryParams params) throws PaddleException {
    try {
      Map<String, Object> map = convertToMap(params);
      URI uri;
      if (map != null && !map.isEmpty()) {
        uri = httpClient().queryParameters(String.format("%s/%s", baseUrl(), PRODUCTS), map);
      } else {
        uri = URI.create(String.format("%s/%s", baseUrl(), PRICES));
      }
      HttpRequest request = httpClient().request(
          uri, HttpMethod.GET.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());

      if (response.statusCode() == 200) {
        PaddleResponse<List<Product>> products = getObjectMapper().readValue(response.body(),
            new TypeReference<>() {
            });
        return products.getData();
      } else {
        throw new PaddleClientException(response.body(), response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  public Product retrieve(String productId) throws PaddleException {
    try {
      HttpRequest request = httpClient().request(
          URI.create(String.format("%s/%s/%s", baseUrl(), PRODUCTS, productId)),
          HttpMethod.GET.name(),
          HttpRequest.BodyPublishers.noBody());
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      return get(request);
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  //TODO - Implementation pending
  public Product updateProduct(ProductUpdateParams update) {
    return null;
  }

  @Override
  protected Product convertResponse(HttpResponse<String> response) throws PaddleException {
    try {
      PaddleResponse<Product> paddleResponse = getObjectMapper().readValue(response.body(),
          new TypeReference<>() {

          });
      return paddleResponse.getData();
    } catch (Exception e) {
      throw new PaddleException(e);
    }
  }
}
