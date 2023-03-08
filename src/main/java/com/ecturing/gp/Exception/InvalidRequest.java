package com.ecturing.gp.Exception;

public class InvalidRequest extends RuntimeException{
    public InvalidRequest(String message) {
        super(message);
    }
}
