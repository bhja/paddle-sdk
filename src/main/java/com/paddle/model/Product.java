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
public class Product extends PaddleBase {

    private String id;
    private String name;

    @JsonProperty("tax_category")
    private String taxCategory;
    private String description;

    @JsonProperty("image_url")
    private String imageUrl;



    private String type;



}
