package com.paddle.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paddle.exception.PaddleException;
import com.paddle.model.PaddleResponse;

import java.net.http.HttpResponse;

public class ApiResource<T> {
    private final ObjectMapper objectMapper;
    protected static final String POST = "POST";
    protected static final String GET = "GET";
    protected static final String PUT = "PUT";

    protected static final String ADDRESS_ID="address_id";
    protected static  final String CUSTOMER_ID="customer_id";
    protected static final String CUSTOMERS = "customers";

    private final String baseUrl;
    private final HTTPClient client;

    public ApiResource(HTTPConfig config) {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        this.client = new HTTPClient(config);
        this.baseUrl = config.getBaseUrl();
    }


    protected ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    protected HTTPClient httpClient() {
        return client;
    }

    protected String baseUrl(){
        return baseUrl;
    }

    protected T converterResponse(HttpResponse<String> response) throws PaddleException{
        try {
            PaddleResponse<T> paddleResponse = getObjectMapper().readValue(response.body(),
                                                                 new TypeReference<>() {
                                                                 });
            return paddleResponse.getData();
        }catch (Exception e){
            throw new PaddleException(e);
        }
    }


}
