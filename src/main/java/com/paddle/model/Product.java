package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
public class Product {

    private String id;
    private String name;

    @JsonProperty("tax_category")
    private String taxCategory;
    private String description;

    @JsonProperty("image_url")
    private String imageUrl;


    @JsonProperty("custom_data")
    private Map<String, Object> customData;
    private String status;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

}
