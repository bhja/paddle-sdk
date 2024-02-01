package com.paddle.address;

import com.paddle.exception.PaddleClientException;
import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.model.Address;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddressService
        extends ApiResource<Address> {
    private static final String ADDRESSES = "addresses";

    public AddressService(HTTPConfig config) {
        super(config);
    }

    public Address getAddress(String customerId,String addressId) throws PaddleException{
        try {
            HttpRequest request = httpClient().request(URI.create(String.format("%s/%s/%s/%s", baseUrl(),
                                                                                CUSTOMERS,customerId, ADDRESSES,addressId)),
                                                       POST,
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
