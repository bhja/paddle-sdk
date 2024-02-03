package com.paddle.model;

import com.paddle.model.enums.EInterval;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentTerm {

  private EInterval interval;
  private String frequency;
}
