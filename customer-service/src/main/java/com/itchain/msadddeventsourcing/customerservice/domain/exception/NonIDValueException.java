package com.itchain.msadddeventsourcing.customerservice.domain.exception;

public class NonIDValueException extends RuntimeException {
    public NonIDValueException() {
        super("ID has no value!");
    }
}
