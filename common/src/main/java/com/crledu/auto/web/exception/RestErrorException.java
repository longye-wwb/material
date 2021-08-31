package com.crledu.auto.web.exception;

/**
 ************************************************************
 * @Description: 普通业务返回错误码异常。使用此异常后接口
 * 返回为错误码和错误提示。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 16:01
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class RestErrorException extends Exception{

    private String code;

    public RestErrorException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
