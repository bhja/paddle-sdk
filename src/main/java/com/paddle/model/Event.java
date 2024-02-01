package com.paddle.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
