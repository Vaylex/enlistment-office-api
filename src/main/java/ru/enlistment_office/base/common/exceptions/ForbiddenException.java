package ru.enlistment_office.base.common.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(final String message) {
        super(message);
    }
}
