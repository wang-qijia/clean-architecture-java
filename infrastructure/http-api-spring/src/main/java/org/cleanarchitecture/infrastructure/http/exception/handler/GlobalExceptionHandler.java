package org.cleanarchitecture.infrastructure.http.exception.handler;


import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    public static ErrorResponse buildErrorResponseStatus(final HttpStatus httpStatus,
        final String message, final String path) {
        return new ErrorResponse(httpStatus.getReasonPhrase(), message, path, httpStatus.value(),
            LocalDateTime.now().toString());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorResponse handleHttpMessageNotReadableException(
        final HttpMessageNotReadableException exception, final Locale locale) {
        final String message = messageSource.getMessage(
            "exception.request.body.is.invalid.or.missing", null, locale);
        return buildErrorResponseStatus(HttpStatus.BAD_REQUEST, message, "/");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ErrorResponse handleBindException(final BindException exception, final Locale locale) {
        final Object[] args = {
            StringUtils.substringBetween(exception.getMessage(), "property '", "'")};
        final String message = messageSource.getMessage("exception.field.format", args, locale);
        return buildErrorResponseStatus(HttpStatus.BAD_REQUEST, message, "/");
    }

//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ErrorResponseStatus handleConstraintViolationException(final ConstraintViolationException exception, final Locale locale) {
//        final String message = messageSource.getMessage(exception.getMessage(), null, locale);
//        return buildErrorResponseStatus(HttpStatus.BAD_REQUEST, message, "/");
//    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(
        final MethodArgumentNotValidException exception, final Locale locale) {
        final List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        final String message = errors.stream().map(error -> messageSource.getMessage(error, locale))
            .collect(Collectors.joining(", "));
        return buildErrorResponseStatus(HttpStatus.BAD_REQUEST, message, "/");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorResponse handleAccessDeniedException(final AccessDeniedException exception,
        final Locale locale) {
        final String message = messageSource.getMessage("exception.access.denied", null, locale);
        return buildErrorResponseStatus(HttpStatus.FORBIDDEN, message, "/");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(final Exception exception, final Locale locale) {
        log.error("Exception: {}", exception.getMessage());
        final String message = messageSource.getMessage("exception.unexpected", null, locale);
        return buildErrorResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR, message, "/");
    }

    public static class ErrorResponse {

        private final String error;
        private final String message;
        private final String path;
        private final int status;
        private final String timestamp;

        @JsonCreator
        ErrorResponse(@JsonProperty("error") String error,
            @JsonProperty("message") String message,
            @JsonProperty("path") String path,
            @JsonProperty("status") int status,
            @JsonProperty("timestamp") String timestamp) {
            this.error = requireNonNull(error, "error");
            this.message = requireNonNull(message, "message");
            this.path = requireNonNull(path, "path");
            this.status = status;
            this.timestamp = requireNonNull(timestamp, "timestamp");
        }

        @JsonProperty
        public String error() {
            return error;
        }

        @JsonProperty
        public String message() {
            return message;
        }

        @JsonProperty
        public String path() {
            return path;
        }

        @JsonProperty
        public int status() {
            return status;
        }

        @JsonProperty
        public String timestamp() {
            return timestamp;
        }
    }
}
