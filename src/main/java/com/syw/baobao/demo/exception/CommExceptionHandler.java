package com.syw.baobao.demo.exception;

import com.syw.baobao.demo.entiy.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class CommExceptionHandler {
    @ExceptionHandler
    public Result messageErrorException(MyException e) {
       return Result.error(e.getCode(), e.getMessage());
    }
}
