package cn.mailke.snowflake.vo;

import lombok.Data;

/**
 * @program: snowflake
 * @description: basevo
 * @author: Johhny Chin
 * @create: 2019-03-28-12-48
 **/
@Data
public class BaseVO<T> {

    private int code;
    private String msg;
    private T data;

    public BaseVO() {
        this.code = 10000;
        this.msg = "操作成功";
    }

    public BaseVO(String msg) {
        this.code = 10000;
        this.msg = msg;
    }

    public BaseVO(String msg, T data) {
        this.code = 10000;
        this.msg = msg;
        this.data = data;
    }

    public BaseVO(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}