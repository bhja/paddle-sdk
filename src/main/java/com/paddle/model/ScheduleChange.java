package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleChange {

  private String action;
  @JsonProperty("resume_at")
  private LocalDateTime resumeAt;

  @JsonProperty("effective_at")
  private LocalDateTime effectiveAt;
}
