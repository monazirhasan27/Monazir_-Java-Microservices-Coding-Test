package com.monazir.orderservice.exception;

public class MissingRequiredField extends RuntimeException {

    public MissingRequiredField(String message) {
        super(message);
    }

}