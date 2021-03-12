package com.luobo.exception;

import lombok.Data;

/**
 * LogException class
 *
 * @author chenlingyu
 * @date 2020/6/10 11:19
 */
@Data
public class ErrorLogException extends Exception {
    private String logMsg;
    public ErrorLogException(String customMsg){
        this.logMsg=customMsg;
    }
}
