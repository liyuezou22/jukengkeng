package com.lyz.springboot.star.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,String> adviceException(Exception ex){
        Map<String,String> map = new HashMap<>();
        map.put("code","-1" );
        map.put("msg",ex.getMessage());
        return map;
    }
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Map<String,String> myException(BusinessException b){
        Map<String,String> map = new HashMap<>();
        map.put("code",b.getCode());
        map.put("msg",b.getMessage());
        return map;
    }

}
