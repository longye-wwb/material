package com.crledu.auto.auth.model;

import org.springframework.security.core.GrantedAuthority;

/**
 ************************************************************
 * @Description: 角色或权限转化为security的授权结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:29
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BaseGrantedAuthority implements GrantedAuthority {

    /**
     * 授权唯一编码
     */
    private String code;

    /**
     * 编码的前缀。
     */
    private String prefix;

    public BaseGrantedAuthority(String code, String prefix) {
        this.code = code;
        this.prefix = prefix;
    }

    @Override
    public String getAuthority() {
        if(prefix ==null || prefix.trim().isEmpty()){
            return code.trim().toUpperCase();
        }else{
            return prefix.trim().toUpperCase() + "_" + code.trim().toUpperCase();
        }
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
