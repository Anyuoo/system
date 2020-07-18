package com.anyu.system.common.api;

/**
 * @author Anyu
 * @since 2020/7/18
 * 封装api数据，常见的操作码
 */
public enum ResultCode implements IErrorCode{
    SUCCESS(200,"操作成功！"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期");

    private int code;
    private String msg;
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
