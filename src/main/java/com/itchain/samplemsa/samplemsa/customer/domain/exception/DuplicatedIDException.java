package com.itchain.samplemsa.samplemsa.customer.domain.exception;

public class DuplicatedIDException extends RuntimeException {
    public DuplicatedIDException() {
        super("ID is duplicated!");
    }
}
