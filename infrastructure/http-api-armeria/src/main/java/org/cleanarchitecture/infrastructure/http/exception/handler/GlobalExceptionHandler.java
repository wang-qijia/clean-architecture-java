package org.cleanarchitecture.infrastructure.http.exception.handler;

import static java.util.Objects.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction;
import io.micrometer.core.instrument.config.validate.ValidationException;
import java.time.Instant;

import org.cleanarchitecture.core.usecase.exception.ErrorCode;
import org.cleanarchitecture.core.usecase.exception.UseCaseException;
import org.cleanarchitecture.infrastructure.http.error.ErrorResponse;
import org.cleanarchitecture.infrastructure.http.error.HttpErrorCode;


public class GlobalExceptionHandler implements ExceptionHandlerFunction {

    @Override
    public HttpResponse handleException(ServiceRequestContext ctx, HttpRequest req, Throwable cause) {
        if (cause instanceof ValidationException) {
            final HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorCode errorCode = HttpErrorCode.INVALID_PARAMETER;
            return HttpResponse.ofJson(status, new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
        }

        if (cause instanceof UseCaseException) {
            UseCaseException caseException = (UseCaseException) cause;
            final HttpStatus status = HttpStatus.BAD_REQUEST;
            ErrorCode errorCode = caseException.getErrorCode();
            return HttpResponse.ofJson(status, new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
        } else if ((cause instanceof Exception)) {
            final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
            ErrorCode errorCode =HttpErrorCode.INTERNAL_SERVER_ERROR;
            return HttpResponse.ofJson(status, new ErrorResponse(errorCode.getCode(), errorCode.getMessage()));
        }
        return ExceptionHandlerFunction.fallthrough();
    }


}