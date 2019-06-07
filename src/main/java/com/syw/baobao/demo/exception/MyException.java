package com.syw.baobao.demo.exception;

import org.springframework.web.bind.annotation.ResponseBody;


@ResponseBody
public class MyException extends RuntimeException {
    private int code;
    private String message;

    public MyException(String message) {
        this.code = 401;
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
