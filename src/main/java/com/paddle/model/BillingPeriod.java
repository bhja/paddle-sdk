package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillingPeriod {

  @JsonProperty("starts_at")
  private LocalDateTime startsAt;

  @JsonProperty("ends_at")
  private LocalDateTime endsAt;
}
