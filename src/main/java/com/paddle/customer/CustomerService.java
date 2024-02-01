package com.paddle.customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.paddle.exception.PaddleClientException;
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
import java.util.Map;

/**
 * Customer related handler for Paddle
 */

public class CustomerService
        extends ApiResource<Customer> {



    public CustomerService(HTTPConfig config) {
        super(config);
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
            HttpRequest request = httpClient().request(URI.create(String.format("%s/%s", baseUrl(), CUSTOMERS)),
                                                       HttpMethod.POST.name(),
                                                       HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
            HttpResponse<String> response = httpClient().execute(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                PaddleResponse<Customer> customerResponse = getObjectMapper().readValue(response.body(),
                                                                                        new TypeReference<>() {
                                                                                        });
                return customerResponse.getData();
            } else {
                throw new PaddleClientException(response.body(), response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            throw new PaddleException(e);
        }
    }

    public Customer getCustomer(String customerId) throws PaddleException {
        try {
            HttpRequest request = httpClient().request(httpClient().queryParameters(String.format("%s/%s", baseUrl(),
                                                                                                  CUSTOMERS),
                                                                                    Map.of(CUSTOMER_ID, customerId)),
                                                       HttpMethod.GET.name(),
                                                       HttpRequest.BodyPublishers.noBody());
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
