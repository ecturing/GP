package com.ecturing.Gp.Exception;

public class InvalidRequest extends RuntimeException{
    public InvalidRequest(String message) {
        super(message);
    }
}
