package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaddleBase {

  @JsonProperty("custom_data")
  private Map<String, Object> customData;
  private String status;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;

  @JsonProperty("import_meta")
  private Map<String, Object> importMeta;
  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;
}
