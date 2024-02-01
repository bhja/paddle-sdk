package com.paddle.exception;

public class PaddleClientException
        extends RuntimeException {
    private final int code;

    public PaddleClientException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
