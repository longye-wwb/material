package com.crledu.auto.web.response;

import java.io.Serializable;

/**
 * @Author: Trevor
 * @Date: 2020/6/29 14:01
 * @Description:
 */
public enum ResponseState implements Serializable {
    FAIL("1", "失败"),
    SUCCESS("0", "成功"),
    UNLOGIN("401", "用户未登录。"),
    NO_RESOURCE("403", "权限不足"),
    NOT_EXITS("2", "Data does not exist!"),
    EXITS("3", "The data has already existed!"),
    UNKNOW("4", "unknown error!"),
    EXCEPTION("5", "Server handling exceptions!"),
    PARAM_ERROR("6", "Parameter error!"),
    TIMEOUT("7", "timeout!");

    private String code;
    private String codeInfo;

    private ResponseState(String code, String codeInfo) {
        this.code = code;
        this.codeInfo = codeInfo;
    }

    public String getCode() {
        return this.code;
    }

    public String getCodeInfo() {
        return this.codeInfo;
    }
}
