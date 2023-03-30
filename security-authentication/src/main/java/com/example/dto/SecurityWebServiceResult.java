package com.example.dto;

import lombok.Data;

/**
 * @author jianping.yu@karakal.com.cn
 * @version 1.0
 * @date 2023/3/30
 **/
@Data
public class SecurityWebServiceResult<T> {
    private Integer status;

    private String message;

    private T data;

    /**
     * 构造器私有
     */
    private SecurityWebServiceResult() {
    }

    /**
     * 通用返回成功
     *
     * @return XmlApiResult
     */
    public static <T> SecurityWebServiceResult<T> ok(T data) {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        securityWebServiceResult.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        securityWebServiceResult.setData(data);
        return securityWebServiceResult;
    }

    public static <T> SecurityWebServiceResult<T> ok() {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        securityWebServiceResult.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return securityWebServiceResult;
    }

    /**
     * 通用返回成功
     *
     * @return XmlApiResult
     */
    public static <T> SecurityWebServiceResult<T> ok(String message,T data) {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.SUCCESS.getStatus());
        securityWebServiceResult.setMessage(message);
        securityWebServiceResult.setData(data);
        return securityWebServiceResult;
    }

    /**
     * 通用返回失败，未知错误
     *
     * @return XmlApiResult
     */
    public static SecurityWebServiceResult error() {
        SecurityWebServiceResult securityWebServiceResult = new SecurityWebServiceResult();
        securityWebServiceResult.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        securityWebServiceResult.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return securityWebServiceResult;
    }


    /**
     * 通用返回失败，未知错误
     *
     * @return XmlApiResult
     */
    public static <T>  SecurityWebServiceResult<T> error(T data) {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        securityWebServiceResult.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        securityWebServiceResult.setData(data);
        return securityWebServiceResult;
    }

    /**
     * 通用返回失败，未知错误
     *
     * @return XmlApiResult
     */
    public static <T>  SecurityWebServiceResult<T> error(String message,T data) {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        securityWebServiceResult.setMessage(message);
        securityWebServiceResult.setData(data);
        return securityWebServiceResult;
    }

    public static <T>  SecurityWebServiceResult<T> error(String message) {
        SecurityWebServiceResult<T> securityWebServiceResult = new SecurityWebServiceResult<>();
        securityWebServiceResult.setStatus(ResultCodeEnum.UNKNOWN_ERROR.getStatus());
        securityWebServiceResult.setMessage(message);
        return securityWebServiceResult;
    }

    /**
     * 设置结果，形参为结果枚举
     *
     * @param result result
     * @return XmlApiResult
     */
    public static SecurityWebServiceResult setResult(ResultCodeEnum result) {
        SecurityWebServiceResult securityWebServiceResult = new SecurityWebServiceResult();
        securityWebServiceResult.setStatus(result.getStatus());
        securityWebServiceResult.setMessage(result.getMessage());
        return securityWebServiceResult;
    }

    /**
     * 通用设置data
     *
     * @param data data
     * @return XmlApiResult
     */
    public SecurityWebServiceResult data(T data) {
        this.data = data;
        return this;
    }

    /**
     * 自定义状态信息
     *
     * @param message message
     * @return XmlApiResult
     */
    public SecurityWebServiceResult message(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 自定义状态码
     *
     * @param code code
     * @return XmlApiResult
     */
    public SecurityWebServiceResult code(Integer code) {
        this.setStatus(code);
        return this;
    }
}
