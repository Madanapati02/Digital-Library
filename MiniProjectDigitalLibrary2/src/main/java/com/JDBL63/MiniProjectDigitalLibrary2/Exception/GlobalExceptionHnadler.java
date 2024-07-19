package com.JDBL63.MiniProjectDigitalLibrary2.Exception;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHnadler {
    @ExceptionHandler
    public ResponseEntity<Map<String,String>> GlobalHandler(MethodArgumentNotValidException exception, HttpServletRequest httpServletRequest)
    {
        Map<String,String> errorInfo=new LinkedHashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errorInfo.put(fieldName,errorMessage);
                });
        return new  ResponseEntity<>(errorInfo,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BadRequestExceptuion.class)
    public ResponseEntity<String> handler(BadRequestExceptuion badRequestExceptuion)
    {
        return new ResponseEntity<>(badRequestExceptuion.getMessage(),HttpStatus.BAD_REQUEST);
    }
}
