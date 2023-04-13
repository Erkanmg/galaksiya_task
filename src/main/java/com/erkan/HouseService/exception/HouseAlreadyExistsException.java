package com.erkan.HouseService.exception;

public class HouseAlreadyExistsException extends RuntimeException {
    public HouseAlreadyExistsException(String msg) {
        super(msg);
    }
}

