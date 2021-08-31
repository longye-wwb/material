package com.crledu.auto.web.exception;

/**
 ************************************************************
 * @Description: 声明式事务回滚使用此异常可以触发
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/6/30 16:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class RestRuntimeException extends RuntimeException{

    private String code;

    public RestRuntimeException(String message, String code) {
        super(message);
        this.code = code;
    }

    public RestRuntimeException(UserErrorCodeEnum userErrorCodeEnum){
        super(userErrorCodeEnum.getErrorMsg());
        this.code = userErrorCodeEnum.getCode();
    }

    public String getCode() {
        return code;
    }
}
