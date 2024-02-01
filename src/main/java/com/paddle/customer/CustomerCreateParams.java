package com.paddle.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder public class CustomerCreateParams {

    private String name;
    private String email;
    @JsonProperty("custom_data") private Map<String, Object> customData;

}
