package com.sgugo.skyserver;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回结果
 */
@Data
public class R<T> implements Serializable {

    // 响应码
    private Integer code;

    //响应是否成功
    private Boolean status;

    //响应信息
    private String message;

    // 响应的数据
    private T data;

    /**
     * 响应成功：无data
     */
    public static <T> R<T> success(){
        R<T> r = new R<>();
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setStatus(true);
        r.setMessage(ErrorEnum.SUCCESS.getMessage());

        return r;
    }


    /**
     * 响应成功：返回data数据
     */
    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.setCode(ErrorEnum.SUCCESS.getCode());
        r.setStatus(true);
        r.setMessage(ErrorEnum.SUCCESS.getMessage());
        r.setData(data);

        return r;

    }

    /**
     * 响应失败
     */
    public static <T> R<T> fail(ErrorEnum errorEnum){
        R<T> r = new R<>();
        r.setCode(errorEnum.getCode());
        r.setStatus(false);
        r.setMessage(errorEnum.getMessage());

        return r;
    }

}
