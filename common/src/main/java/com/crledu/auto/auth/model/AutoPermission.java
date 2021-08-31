package com.crledu.auto.auth.model;

/**
 ************************************************************
 * @Description: 默认的权限结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:25
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AutoPermission extends BaseGrantedAuthority {

    /**
     * 权限名称
     */
    private String name;

    public AutoPermission(String code) {
        super(code, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
