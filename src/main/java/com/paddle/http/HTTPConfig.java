package com.paddle.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HTTPConfig {
    private String baseUrl;
    private String apiKey;
    private int connectionTimeOut;
    private int readTimeOut;
}
