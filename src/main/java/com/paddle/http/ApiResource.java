package com.paddle.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.model.PaddleResponse;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiResource<T> {

    private final ObjectMapper objectMapper;
    protected static final String CUSTOMER_ID = "customer_id";
    protected static final String CUSTOMERS = "customers";

    protected static final String BUSINESS = "businesses";

    protected static final String PRODUCTS = "products";

    private final String baseUrl;
    private final HTTPClient client;

    public ApiResource(HTTPConfig config) {
        this.objectMapper = new ObjectMapper();
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

    protected T converterResponse(HttpResponse<String> response) throws PaddleException {
        try {
            PaddleResponse<T> paddleResponse = getObjectMapper().readValue(response.body(), new TypeReference<>() {

            });
            return paddleResponse.getData();
        } catch (Exception e) {
            throw new PaddleException(e);
        }
    }

    protected T create(HttpRequest request) throws PaddleException {
        try {
            HttpResponse<String> response = httpClient().execute(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                return converterResponse(response);
            } else {
                throw new PaddleClientException(response.body(), response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new PaddleException(e);
        }
    }

    public T get(HttpRequest request) throws PaddleException {
        try {
            HttpResponse<String> response = httpClient().execute(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return converterResponse(response);
            } else {
                throw new PaddleClientException(response.body(), response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new PaddleException(e);
        }
    }

}
