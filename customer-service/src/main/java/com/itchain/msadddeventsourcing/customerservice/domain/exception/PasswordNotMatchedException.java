package com.itchain.msadddeventsourcing.customerservice.domain.exception;

public class PasswordNotMatchedException extends RuntimeException {
    public PasswordNotMatchedException() {
        super("Password is not matched!");
    }
}
