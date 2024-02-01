package com.paddle;

import com.paddle.address.AddressService;
import com.paddle.customer.CustomerService;
import com.paddle.http.HTTPConfig;

public class PaddleClient {

    private final HTTPConfig config;

    public PaddleClient(HTTPConfig config) {
        this.config = config;
    }

    public CustomerService customers() {
        return new CustomerService(this.config);
    }

    public AddressService addresses() {
        return new AddressService(this.config);
    }
}
