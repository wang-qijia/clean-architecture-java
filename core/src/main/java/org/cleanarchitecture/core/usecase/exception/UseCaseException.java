package org.cleanarchitecture.core.usecase.exception;

/**
 * @author : wangqijia create at:  2024/12/5  10:32 AM
 */
public class UseCaseException extends RuntimeException {

    private final ErrorCode errorCode;

    public UseCaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public UseCaseException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public UseCaseException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }


    public UseCaseException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
