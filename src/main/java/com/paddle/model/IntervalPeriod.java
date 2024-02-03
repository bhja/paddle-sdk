package com.paddle.model;

import com.paddle.model.enums.EInterval;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IntervalPeriod {

  private EInterval interval;
  private int frequency;

}
