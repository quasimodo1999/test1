package com.example.test.config;

import com.example.test.exception.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

// 加了这个注解，出了异常就会被这个全局异常类捕获
@RestControllerAdvice
public class CustomExceptionHandler {

    // 捕获我们的自定义异常
    @ExceptionHandler(MyException.class)
    public Object handleException (MyException e, HttpServletRequest request) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", e.getCode());
        map.put("msg",e.getMessage());
        map.put("url",request.getRequestURL());
        return map;
    }
}
