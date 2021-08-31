package com.crledu.auto.web.exception;


/**
 * @Author: Trevor
 * @Date: 2020/7/8 14:03
 * @Description:
 */
public enum UserErrorCodeEnum {

    SUCCESS("0","成功"),

    UNEXPECT_DATA("1000011","数据库存在异常数据。"),

    DOMAIN_KEY_EMPTY("1000010","操作对象主键为空"),

    PARAM_IS_NOT_FIND("1000001","找不到资源，请检查参数"),

    PARAM_FORMAT_ERROR("1000003", "参数格式异常"),

    PRIVATE_RESOURCE("1000002","私有资源"),

    RESOURCE_IS_TIMEOUT("1000004","资源已过期"),

    RESOURCE_IS_EXIST("1000005","资源已存在"),

    RESOURCE_IS_N0T_HAVE("1000006","不具备要操作的资源"),

    ILLEGAL("1000007","传入参数不合法，请检查参数，如下拉多选框等"),

    Exist_DATA("100008","已存在区分标识相同的数据，请检查参数"),

    NOT_SAVED("10000012","业务对象没有背持久化，不能完成业务。"),

    FAILE("-1","失败");



    private String code;
    private String errorMsg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    UserErrorCodeEnum(String code,String errorMsg){

        this.code=code;
        this.errorMsg=errorMsg;
    }

}
