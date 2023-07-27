package com.sgugo.sky.result;
import lombok.Data;
import java.io.Serializable;

/**
 * 后端统一返回结果
 */
@Data
public class R<T> implements Serializable {

    // 响应码
    private Integer code; //编码：1成功，0和其它数字为失败

    //响应信息
    private String msg;

    // 响应的数据
    private T data;

    /**
     * 响应成功：无data
     */
    public static <T> R<T> success(){
        R<T> r = new R<>();
        r.setCode(1);

        return r;
    }


    /**
     * 响应成功：返回data数据
     */
    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.setCode(1);
        r.setData(data);
        return r;
    }

    /**
     * 响应失败
     */
    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }
}
