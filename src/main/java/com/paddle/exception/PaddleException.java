package com.paddle.exception;


public class PaddleException extends Exception{
    public PaddleException(String message){
        super(message);
    }
    public PaddleException(String message,Throwable e){
        super(message,e);
    }
    public PaddleException(Exception e){
        super(e);
    }
}
