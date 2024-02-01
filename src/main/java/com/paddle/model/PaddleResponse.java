package com.paddle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data @AllArgsConstructor @NoArgsConstructor public class PaddleResponse<T> {

    private T data;
    private Map<String, Object> meta;
    private Map<String, Object> error;
}
