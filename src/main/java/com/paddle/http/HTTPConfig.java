package com.paddle.http;

import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor public class HTTPConfig {

    private String baseUrl;
    private String apiKey;
    private int connectionTimeOut;
    private int readTimeOut;
}
