package com.sgugo.sky.handler;

import com.sgugo.sky.constant.MessageConstant;
import com.sgugo.sky.exception.BaseException;
import com.sgugo.sky.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局通用异常处理器，处理所有业务异常
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    /**
     * 业务异常 - 通用处理
     * @param e 基础异常类，所有业务异常类的父类
     * @return 通用响应类
     */
    @ExceptionHandler
    public R exceptionHandler(BaseException e){
        log.error("异常信息：{}",e.getMessage());
        return R.error(e.getMessage());
    }

    /**
     * 处理SQL异常
     * @param e SQL字段的值重复
     * @return 通用响应类
     */
    @ExceptionHandler
    public R exceptionHandler(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        if(message.contains("Duplicate entry")){
            String[] split = message.split(" ");
            String username = split[2];
            String msg = username + MessageConstant.ALREADY_EXISTS;
            return R.error(msg);
        }else{
            return R.error(MessageConstant.UNKNOWN_ERROR);
        }
    }
}
