package com.luobo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * ExceptionController class
 *
 * @author chenlingyu
 * @date 2020/5/2 15:16
 */

@Slf4j
@ControllerAdvice
public class ExceptionInterceptor extends DefaultErrorAttributes {


     @ExceptionHandler(Exception.class)
     @ResponseBody
     public String handleException(Exception e) {
         e.printStackTrace();
         return "500";
     }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {
        String errorMsg="Valid:";
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        for (FieldError error:fieldErrors){
            errorMsg+=" "+error.getField()+":"+error.getDefaultMessage();
        }
        return errorMsg;
    }
}
