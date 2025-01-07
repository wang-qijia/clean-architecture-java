package org.cleanarchitecture.infrastructure.http.exception.handler;


import jakarta.validation.ConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cleanarchitecture.core.usecase.exception.ErrorCode;
import org.cleanarchitecture.infrastructure.http.error.ErrorResponse;
import org.cleanarchitecture.infrastructure.http.error.HttpErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    public static ErrorResponse buildErrorResponseStatus(final ErrorCode errorCode,
        final String message) {
        return new ErrorResponse(errorCode.getCode(), message);
    }

    public static ErrorResponse buildErrorResponseStatus(final ErrorCode errorCode) {
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(
        final HttpMessageNotReadableException exception) {
        return buildErrorResponseStatus(HttpErrorCode.INVALID_PARAMETER);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ErrorResponse handleBindException(final BindException exception) {
        return buildErrorResponseStatus(HttpErrorCode.INVALID_PARAMETER);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolationException(final ConstraintViolationException exception, final Locale locale) {
        return buildErrorResponseStatus(HttpErrorCode.INVALID_PARAMETER);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(
        final MethodArgumentNotValidException exception, final Locale locale) {
        final List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        final String message = errors.stream().map(error -> error.getDefaultMessage())
            .collect(Collectors.joining(", "));
        return buildErrorResponseStatus(HttpErrorCode.INVALID_PARAMETER);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(final Exception exception, final Locale locale) {
        log.error("Exception: {}", exception.getMessage());
        return buildErrorResponseStatus(HttpErrorCode.INVALID_PARAMETER);
    }


}
