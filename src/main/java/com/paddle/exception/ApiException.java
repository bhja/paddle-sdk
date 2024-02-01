package com.paddle.exception;

public class ApiException
        extends PaddleException {
    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable e) {
        super(message, e);
    }

    public ApiException(Exception e) {
        super(e);
    }
}
