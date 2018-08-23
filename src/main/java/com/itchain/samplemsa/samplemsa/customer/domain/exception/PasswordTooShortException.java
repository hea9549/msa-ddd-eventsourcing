package com.itchain.samplemsa.samplemsa.customer.domain.exception;

public class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException() {
        super("password is too short!");
    }
}
