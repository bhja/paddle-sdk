package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
