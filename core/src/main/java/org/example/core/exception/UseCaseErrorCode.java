package org.example.core.exception;

/**
 * @author : wangqijia create at:  2024/12/5  10:45 AM
 */
public enum UseCaseErrorCode implements ErrorCode {

    User_ALREADY_EXISTS("1000", "User already exists"),
    User_NOT_FOUND("1001", "User not found"),
    ;

    private final String code;
    private final String message;

    UseCaseErrorCode(String code, String message) {
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
