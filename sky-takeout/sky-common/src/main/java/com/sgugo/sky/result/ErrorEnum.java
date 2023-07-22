package com.sgugo.sky.result;

public enum ErrorEnum {

    SUCCESS(0,"ok"),
    //设置一个通用错误码，用于前期快速开发
    ERROR(1,"请求失败"),

    ACCOUNT_NOT_LOGIN(101,"账号未登录"),
    ACCOUNT_FREEZE(102,"账号被冻结"),
    ACCOUNT_BAN(103,"账号被封停"),
    ACCOUNT_LOW(104,"账号等级不足"),
    ACCOUNT_NOT_CERTIFICATION(105,"账号未实名"),
    ACCOUNT_NOT_PHONE(106,"账号未绑定手机"),

    REQUEST_BAD(400,"无法解析当前的请求"),
    NOT_FOUND(404,"请求的资源不存在"),
    BAD_METHOD(405,"请求方式错误"),
    BAD_PARAM(406,"请求参数错误"),

    SERVER_ERROR(500,"服务器内部错误"),
    BAD_GATEWAY(502,"网关错误"),
    SERVICE_UNAVAILABLE(504,"服务器过载保护");


    private final Integer code;
    private final String message;

    ErrorEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
