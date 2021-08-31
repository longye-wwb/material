package com.crledu.auto.material.user.biz.dto;

import com.crledu.auto.auth.model.BaseGrantedAuthority;

/**
 ************************************************************
 * @Description: 用户角色权限
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 14:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class RoleAuthority extends BaseGrantedAuthority {

    /**
     * 角色名称
     */
    private String name = "默认角色";

    public RoleAuthority(String code) {
        super(code, "role");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
