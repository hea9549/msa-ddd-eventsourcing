package com.itchain.samplemsa.samplemsa.customer.domain.exception;

public class NonIDValueException extends RuntimeException {
    public NonIDValueException() {
        super("ID has no value!");
    }
}
