package com.crledu.auto.material.user.biz.dto;

import com.crledu.auto.web.view.PageParamVO;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 用户选择条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 10:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class UserSelectDto extends PageParamVO {

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户电话")
    private String mobel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobel() {
        return mobel;
    }

    public void setMobel(String mobel) {
        this.mobel = mobel;
    }
}
