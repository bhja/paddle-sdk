package com.paddle.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.model.QueryParams;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class ApiResource<T> {

  private final ObjectMapper objectMapper;

  protected static final String CUSTOMERS = "customers";

  protected static final String BUSINESS = "businesses";

  protected static final String PRODUCTS = "products";

  protected static final String PRICES = "prices";
  protected static final String DISCOUNT = "discounts";
  protected static final String SUBSCRIPTION = "subscriptions";
  protected static final String TRANSACTIONS = "transactions";

  private final String baseUrl;
  private final HTTPClient client;

  public ApiResource(HTTPConfig config) {
    this.objectMapper = new ObjectMapper().configure(
        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    ;
    this.objectMapper.findAndRegisterModules();

    this.client = new HTTPClient(config);
    this.baseUrl = config.getBaseUrl();
  }

  protected ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  protected HTTPClient httpClient() {
    return client;
  }

  protected String baseUrl() {
    return baseUrl;
  }

  protected abstract T convertResponse(HttpResponse<String> response) throws PaddleException;

  protected T create(HttpRequest request) throws PaddleException {
    try {
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 201) {
        return convertResponse(response);
      } else {
        throw new PaddleClientException(response.body(), response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  public T get(HttpRequest request) throws PaddleException {
    try {
      HttpResponse<String> response = httpClient().execute(request,
          HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return convertResponse(response);
      } else {
        throw new PaddleClientException(response.body(), response.statusCode());
      }
    } catch (IOException | InterruptedException e) {
      throw new PaddleException(e);
    }
  }

  protected Map<String, Object> convertToMap(QueryParams params) {
    Map<String, Object> map = objectMapper.convertValue(
        params,
        new TypeReference<Map<String, Object>>() {
        }
    );
    return map.entrySet().stream()
        .filter(e -> e.getValue() != null)
        .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
  }

}
