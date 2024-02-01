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
public class PaddleBase {
    @JsonProperty("custom_data")
    private Map<String, Object> customData;
    private String status;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("import_meta")
    private Map<String,Object> importMeta;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
