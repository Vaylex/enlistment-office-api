package ru.enlistment_office.base.features.advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.webjars.NotFoundException;
import ru.enlistment_office.base.common.exceptions.BadRequestException;
import ru.enlistment_office.base.common.exceptions.ForbiddenException;
import ru.enlistment_office.base.features.advice.dto.ExceptionBody;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleResourceNotFound(final NotFoundException e) {
        return new ExceptionBody(e.getMessage(), "resource_not_found_error");
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionBody handleForbidden(final ForbiddenException e) {
        return new ExceptionBody(e.getMessage(), "forbidden_error");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleDataIntegrityViolation(final DataIntegrityViolationException e) {
        return new ExceptionBody(e.getMessage(), "data_integrity_violation_error");
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionBody handleBadRequestException(final BadRequestException e) {
        return new ExceptionBody(e.getMessage(), "bad_request_error");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionBody handleException(final Exception e) {
        return new ExceptionBody(e.getMessage(), "internal_error");
    }
}