package com.luobo.interceptor;


import com.luobo.exception.CustomException;
import com.luobo.exception.ErrorLogException;
import com.luobo.utils.CodeMessageHandle;
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

    @Autowired
    private CodeMessageHandle codeMessageHandle;

     @ExceptionHandler(Exception.class)
     @ResponseBody
     public String handleException(Exception e) {
         e.printStackTrace();
         return codeMessageHandle.code(500).toString();
     }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public String validExceptionHandler(BindException e, WebRequest request, HttpServletResponse response) {
        String errorMsg="参数验证失败:";
        List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
        for (FieldError error:fieldErrors){
            errorMsg+=" "+error.getField()+":"+error.getDefaultMessage();
        }
        return codeMessageHandle.code(500).customMsg(errorMsg).toString();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public String customExceptionHandler(CustomException e, WebRequest request, HttpServletResponse response) {
        return codeMessageHandle.code(500).customMsg(e.getCustomMsg()).toString();
    }

    @ExceptionHandler(ErrorLogException.class)
    public void errorLogExceptionHandler(ErrorLogException e, WebRequest request, HttpServletResponse response) {
         log.error(e.getLogMsg());
    }
}
