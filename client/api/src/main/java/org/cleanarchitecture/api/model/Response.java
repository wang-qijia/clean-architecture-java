package org.cleanarchitecture.api.model;

/**
 * @author : wangqijia create at:  2024/12/5  5:32 PM
 */
public class Response<T> {

    private String code;
    private String message;

    private T data;

    public Response() {
    }

    private Response(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>("0", "", data);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
