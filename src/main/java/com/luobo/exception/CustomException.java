package com.luobo.exception;

import lombok.Data;

/**
 * CustomException class
 *
 * @author chenlingyu
 * @date 2020/5/13 14:43
 */
@Data
public class CustomException extends RuntimeException{
    private String customMsg;
    public CustomException(String customMsg){
        this.customMsg=customMsg;
    }
}
