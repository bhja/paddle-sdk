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
public class Address {
  private String id;
  private String description;
  @JsonProperty("first_line")
  private String firstLine;
  @JsonProperty("second_line")
  private String secondLine;
  private String city;
  @JsonProperty("postal_code")
  private String postalCode;
  private String region;

  @JsonProperty("country_code")
  private String countryCode;

  @JsonProperty("custom_data")
  private Map<String, Object> customData;
  private String status;

  @JsonProperty("created_at")
  private LocalDateTime createdAt;
  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;
}
