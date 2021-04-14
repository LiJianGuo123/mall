package com.onestep.mall.utils;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Result<T> implements Serializable {

    public static final long serialVersionUID = 1L;

    public static final Result<String> FAIL = new Result<String>(500,null);

    public static final Result<String> SUCCESS = new Result<String>(200,null);

    @ApiModelProperty("返回码")
    private int resultCode;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回参数")
    private T data;

    public Result(){
        //无餐构造方法
    }

    public Result(int resultCode,String message){
        this.resultCode = resultCode;
        this.message = message;//有餐
    }

    public Result(int resultCode){
        this.resultCode = resultCode;
    }

    public Result (T date){
        this.resultCode = 200;
        this.message = "success";
        this.data = date;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
