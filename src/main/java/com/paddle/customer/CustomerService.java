package com.paddle.customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleError;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPClient;
import com.paddle.model.Customer;
import com.paddle.model.PaddleResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class CustomerService extends ApiResource {

    private String baseUrl ;
    private HTTPClient client;
    private static final String CUSTOMERS = "customers";

    public CustomerService(String apiKey,String baseUrl){
        this.client = new HTTPClient(apiKey);
        this.baseUrl = baseUrl;
    }

    /**
     * Creates the customer .Returns 409 if already exists.
     * @param params
     * @return {@link Customer}
     * @throws PaddleException
     */
    public Customer createCustomer(CustomerCreateParams params) throws PaddleException {
        try {
            HttpRequest request = client.request(URI.create(String.format("%s/%s", baseUrl, CUSTOMERS)), POST,
                                                 HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
            HttpResponse<String> response = client.execute(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                PaddleResponse<Customer> customerResponse = getObjectMapper().readValue(response.body(),
                                                                                        new TypeReference<>(){});
                return customerResponse.getData();
            } else {
                throw new PaddleException(response.body());
            }
        }catch (IOException | InterruptedException e){
            throw new PaddleException(e);
        }
    }
}
