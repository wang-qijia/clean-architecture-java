package org.example.core.exception;

/**
 * @author : wangqijia create at:  2024/12/5  10:45 AM
 */
public enum UseCaseErrorCode implements ErrorCode {

    STUDENT_ALREADY_EXISTS("1000", "Student already exists"),
    STUDENT_NOT_FOUND("1001", "Student not found"),
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
