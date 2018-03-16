package com.hoolai.mxt.common;

/**
 * @author liubowen
 * @date 2018/3/16 11:17
 * @description
 */
public enum ErrorCode {

    ERROR(0, "错误"),
    SUCCESS(1, "成功"),
    NOT_REGISTE(1001, "帐号未注册"),
    ERROR_PASSWORD(1002, "密码错误"),
    NOT_INPUT_USERNAME(1003, "请输入帐号"),
    NOT_INPUT_PASSWORD(1004, "请输入密码"),
    NOT_INPUT_REALNAME(1005, "请输入姓名"),
    NOT_INPUT_IDCARD(1006, "请输入身份证"),
    ILLEGAL_USERNAME(1007, "账号输入不合法"),
    ILLEGAL_REALNAME(1008, "姓名输入不合法"),
    ILLEGAL_IDCARD(1009, "身份证输入不合法"),
    ;

    public int code;
    public String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
