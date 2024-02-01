package com.paddle.address;

import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Address;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class AddressService extends ApiResource<Address> {

    private static final String ADDRESSES = "addresses";

    public AddressService(HTTPConfig config) {
        super(config);
    }

    public Address getAddress(String customerId, String addressId) throws PaddleException {
        HttpRequest request = httpClient().request(
                URI.create(String.format("%s/%s/%s/%s", baseUrl(), CUSTOMERS, customerId, ADDRESSES, addressId)), HttpMethod.GET.name(),
                HttpRequest.BodyPublishers.noBody());
        return get(request);
    }

    public Address createAddress(String customerId, AddressCreateParams params) throws PaddleException {
        try {
            HttpRequest request = httpClient().request(URI.create(String.format("%s/%s/%s", baseUrl(), CUSTOMERS, customerId, ADDRESSES)),
                    HttpMethod.POST.name(), HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
            return create(request);
        } catch (IOException e) {
            throw new PaddleException(e);
        }
    }

}
