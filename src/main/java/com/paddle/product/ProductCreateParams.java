package com.paddle.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder public class ProductCreateParams {

    private String name;

    @JsonProperty("tax_category") private String taxCategory;
    private String description;

    @JsonProperty("image_url") private String imageUrl;
    @JsonProperty("custom_data") private Map<String, Object> customData;

}
