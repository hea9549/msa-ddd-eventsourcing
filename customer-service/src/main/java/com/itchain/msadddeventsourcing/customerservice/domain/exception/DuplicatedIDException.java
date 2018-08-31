package com.itchain.msadddeventsourcing.customerservice.domain.exception;

public class DuplicatedIDException extends RuntimeException {
    public DuplicatedIDException() {
        super("ID is duplicated!");
    }
}
