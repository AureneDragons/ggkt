package com.atguigu.ggkt.result;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回状态信息（成功 失败）
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public Result(){};

    /**
     * 成功的方法
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<>();
        if (data != null){
            result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("成功");
        return result;
    }

    /**
     * 失败的方法
     * @param data
     * @return
     * @param <T>
     */
    public static<T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        if (data != null){
            result.setData(data);
        }
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }

    public Result<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result<T> message(String message) {
        this.setMessage(message);
        return this;
    }
}
