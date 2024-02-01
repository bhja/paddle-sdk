package com.paddle.exception;

public class PaddleException extends Exception {

  private int code;

  public PaddleException(String message) {
    super(message);
  }

  public PaddleException(String message, int code, Throwable e) {
    super(message, e);
    this.code = code;
  }

  public PaddleException(String message, Throwable e) {
    super(message, e);
  }

  public PaddleException(Exception e) {
    super(e);
  }

  public int getCode() {
    return code;
  }
}
