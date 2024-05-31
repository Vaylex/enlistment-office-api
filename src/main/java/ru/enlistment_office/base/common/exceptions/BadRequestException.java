package ru.enlistment_office.base.common.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(final String message) {
        super(message);
    }
}
