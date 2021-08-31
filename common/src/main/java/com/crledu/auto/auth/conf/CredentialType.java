package com.crledu.auto.auth.conf;

/**
 ************************************************************
 * @Description: 系统中用户令牌的类型
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/1 10:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public enum CredentialType {
    ACCOUNT(0,"账号密码"),CAS(1,"cas认证服务");

    private Integer code;
    private String name;

    CredentialType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CredentialType findByCode(Integer code){
        CredentialType[] credentialTypes = CredentialType.values();
        for (CredentialType item: credentialTypes) {
            if(item.code.intValue() == code.intValue()){
                return item;
            }
        }
        return ACCOUNT;
    }

    public Integer getCode() {
        return code;
    }
}
