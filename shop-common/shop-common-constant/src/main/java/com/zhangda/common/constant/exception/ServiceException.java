package com.zhangda.common.constant.exception;

/**
 * 业务通用异常
 *
 * @author zhangda
 * @date: 2023/5/6
 **/
public class ServiceException extends RuntimeException {
    private Integer code;
    private String message;

    public ServiceException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message) {
        this(500, message);
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
