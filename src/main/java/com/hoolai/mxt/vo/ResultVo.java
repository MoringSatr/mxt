package com.hoolai.mxt.vo;

import com.google.common.collect.Maps;
import com.hoolai.mxt.common.ErrorCode;
import lombok.Data;

import java.util.Map;

/**
 * @author liubowen
 * @date 2018/3/16 11:15
 * @description
 */
@Data
public class ResultVo {

    private int code;
    private String msg;
    private Map<String, Object> data;

    private ResultVo() {
        this.data = Maps.newHashMap();
    }

    public ResultVo(ErrorCode errorCode) {
        this();
        this.code = errorCode.code;
        this.msg = errorCode.msg;
    }

    public static ResultVo ok() {
        return new ResultVo(ErrorCode.SUCCESS);
    }

    public static ResultVo error() {
        return new ResultVo(ErrorCode.ERROR);
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }
}
