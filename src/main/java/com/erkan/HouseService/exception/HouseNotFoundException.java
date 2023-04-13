package com.erkan.HouseService.exception;

public class HouseNotFoundException extends RuntimeException{
    public HouseNotFoundException(String msg) {
        super(msg);
    }
}
