package com.sgugo.sky.handler;

import com.sgugo.sky.exception.BaseException;
import com.sgugo.sky.result.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局通用异常处理器，处理所有业务异常
 */
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {
    @ExceptionHandler
    public R exceptionHandler(BaseException e){
        log.error("异常信息：{}",e.getMessage());
        return R.error(e.getMessage());
    }
}
