package com.itchain.samplemsa.samplemsa.customer.domain.exception;

public class PasswordNotMatchedException extends RuntimeException{
    public PasswordNotMatchedException() {
        super("Password is not matched!");
    }
}
