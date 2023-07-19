package com.sgugo.skycommon.result;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 后端统一返回结果
 */
@Data
public class R<T> implements Serializable {

    // 响应码
    private Integer code;

    //响应是否成功
    private Boolean success;

    //响应信息
    private String message;

    // 响应的数据
    private T data;


    /*
    * 响应成功：无数据
    * */
    public static <T> R<T> success(){
        R<T> r = new R<>();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage("响应成功");
        return r;
    }


    /*
    * 响应成功：返回单个数据
    * */
    public static <T> R<T> success( T obj){
        R<T> r = new R<>();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage("响应成功");
        r.data = obj;

        return null;
    }


    /**
     * 响应成功: 进行分页
     *
     * 在返回通用数据，data模型的基础上，可以自定义添加map数据
     */





}
