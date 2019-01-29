package com.hundsun.operation.manager.constant;

import java.io.Serializable;

/**
 * @author sunyt
 * @param <T>
 */
public class BaseResult<T> implements Serializable {
    /**
     * 成功
     */
    private static final String SUCCESS = "0";
    /**
     * 失败
     */
    private static final String ERROR = "1";

    /**
     * code
     */
    private String code;

    /**
     * message
     */
    private String message;

    private T data;

    public BaseResult() {

    }

    public BaseResult(T data) {
        this(data, SUCCESS);
    }

    public BaseResult(String code) {
        this.code = code;
    }

    public BaseResult(T data, String code) {
        this.data = data;
        this.code = code;
    }

    public BaseResult(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
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

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(data, SUCCESS);
    }

    public static <T> BaseResult<T> success() {
        return new BaseResult<T>(SUCCESS);
    }

    public static <T> BaseResult<T> error(String errorMessage) {
        return new BaseResult<T>(null, errorMessage);
    }

    public static <T> BaseResult<T> error(T data, String errorMessage) {
        return new BaseResult<T>(data, ERROR, errorMessage);
    }

}
