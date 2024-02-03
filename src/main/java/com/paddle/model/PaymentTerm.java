package com.paddle.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTerm {

  private EInterval interval;
  private String frequency;
}
