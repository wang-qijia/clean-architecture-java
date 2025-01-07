package org.cleanarchitecture.infrastructure.http.error;

import org.cleanarchitecture.core.usecase.exception.ErrorCode;

public enum HttpErrorCode implements ErrorCode {
    INVALID_PARAMETER("1200", "The parameter is invalid"),


    INTERNAL_SERVER_ERROR("1205", "Internal Server Error"),


    ;
    private final String code;
    private final String message;

    HttpErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
