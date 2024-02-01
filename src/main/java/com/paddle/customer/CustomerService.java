package com.paddle.customer;

import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Customer;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

/**
 * Customer related handler for Paddle
 */

public class CustomerService extends ApiResource<Customer> {

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
            HttpRequest request = httpClient().request(URI.create(String.format("%s/%s", baseUrl(), CUSTOMERS)), HttpMethod.POST.name(),
                    HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
            return create(request);
        } catch (IOException e) {
            throw new PaddleException(e);
        }
    }

    public Customer getCustomer(String customerId) throws PaddleException {
        HttpRequest request = httpClient().request(URI.create(String.format("%s/%s/%s", baseUrl(), CUSTOMERS, customerId)),
                HttpMethod.GET.name(), HttpRequest.BodyPublishers.noBody());
        return get(request);

    }
}
