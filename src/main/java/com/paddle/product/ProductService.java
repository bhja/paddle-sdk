package com.paddle.product;

import com.paddle.exception.PaddleException;
import com.paddle.http.ApiResource;
import com.paddle.http.HTTPConfig;
import com.paddle.http.HttpMethod;
import com.paddle.model.Product;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

public class ProductService extends ApiResource<Product> {

    public ProductService(HTTPConfig config) {
        super(config);
    }

    public Product createProduct(ProductCreateParams params) throws PaddleException {
        try {
            HttpRequest request = httpClient().request(URI.create(String.format("%s/%s", baseUrl(), PRODUCTS)), HttpMethod.POST.name(),
                    HttpRequest.BodyPublishers.ofString(getObjectMapper().writeValueAsString(params)));
            return create(request);
        } catch (IOException e) {
            throw new PaddleException(e);
        }
    }

}
