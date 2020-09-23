package com.me.xpxq.xpxqcommon.util;

import java.io.Serializable;

/**
 * 通用的返回结果类
 */
public class Res implements Serializable {
    /**
     * 返回码  200表示成功 40x 50x表示失败
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public Res(){}


    public Res(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 请求成功时返回的结果
     * @return
     */
    public static Res ok(){
        return new Res(200,"success",null);
    }

    public static Res ok(Object data){
        return new Res(200,"success",data);
    }

    /**
     * 失败返回结果
     * @return
     */
    public static Res fail(){
        return new Res(400,"error",null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

