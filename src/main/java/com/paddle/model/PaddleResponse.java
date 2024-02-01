package com.paddle.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaddleResponse<T> {

  private T data;
  private Map<String, Object> meta;
  private Map<String, Object> error;
}
