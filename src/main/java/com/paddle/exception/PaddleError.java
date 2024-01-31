package com.paddle.exception;

public class PaddleError extends Exception{
    public PaddleError(String message){
        super(message);
    }
    public PaddleError(String message,Exception e){
        super(message,e);
    }
}
