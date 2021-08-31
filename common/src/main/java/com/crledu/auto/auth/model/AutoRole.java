package com.crledu.auto.auth.model;

/**
 ************************************************************
 * @Description: 系统默认角色结构。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:24
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AutoRole extends BaseGrantedAuthority {

    /**
     * 角色名称
     */
    private String name = "默认角色";

    public AutoRole(String code) {
        super(code, "role");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
