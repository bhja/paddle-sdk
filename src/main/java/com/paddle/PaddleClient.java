package com.paddle;

import com.paddle.customer.CustomerService;

public class PaddleClient {

    private String apiKey;
    private String baseUrl;
    public PaddleClient(String apiKey,String baseUrl){
            this.apiKey = apiKey;
            this.baseUrl = baseUrl;
    }
    public CustomerService customers(){
        return new CustomerService(this.apiKey,this.baseUrl);
    }

}
