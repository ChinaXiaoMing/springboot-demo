package com.opencode.common;

/**
 * @Description 通用结果处理类
 * @Author xiaoming
 * @Date 2020/3/21 12:27
 * @Version 1.0
 **/
public class Result<T> {

    //状态码
    private int code;
    //提示信息
    private String message;
    //操作成功时获取的响应数据
    private T data;

    public Result() {
    }

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 操作成功返回结果
     * @param data 操作成功获取的响应数据
     * @return Result<T>
     */
    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 操作成功返回结果
     * @param message 操作成功提示信息
     * @param data 操作成功获取的响应数据
     * @return Result<T>
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 操作失败返回结果
     * @return Result<T>
     */
    public static <T> Result<T> failure() {
        return failure(ResultCode.FAILED.getMessage());
    }

    /**
     * 操作失败返回结果
     * @param message 错误提示信息
     * @return Result<T>
     */
    public static <T> Result<T> failure(String message) {
        return failure(ResultCode.FAILED.getCode(), message);
    }

    /**
     * 操作失败返回结果
     * @param code 错误码
     * @param message 错误提示信息
     * @return Result<T>
     */
    public static <T> Result<T> failure(int code, String message) {
        return new Result<T>(code, message, null);
    }

    /**
     * 未认证（未登录或登录过期等）返回结果
     * @return Result<T>
     */
    public static <T> Result<T> unauthorized() {
        return new Result<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), null);
    }

    /**
     * 无权限操作返回结果
     * @return Result<T>
     */
    public static <T> Result<T> forbidden() {
        return new Result<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
