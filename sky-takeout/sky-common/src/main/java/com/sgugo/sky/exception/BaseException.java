package com.sgugo.sky.exception;

public class BaseException extends RuntimeException{
    public BaseException(){

    }

    //接收异常信息作为构造函数的参数
    public BaseException(String msg){
        super(msg);
    }

}
