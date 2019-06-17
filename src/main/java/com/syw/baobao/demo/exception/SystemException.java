package com.syw.baobao.demo.exception;

import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody
public class SystemException extends RuntimeException {
    private int code;
    private String message;

    public SystemException(String message) {
        this.code = 405;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
