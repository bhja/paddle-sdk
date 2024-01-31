package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Event<T> {

  private T data;

  @JsonProperty("event_id")
  private String eventId;
  @JsonProperty("event_type")
  private String eventType;

  @JsonProperty("occurred_at")
  private LocalDateTime occurredAt;
  @JsonProperty("notification_id")
  private String notificationId;


}
