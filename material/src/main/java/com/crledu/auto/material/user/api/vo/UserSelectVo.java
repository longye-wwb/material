package com.crledu.auto.material.user.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 用户列表搜索条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 10:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("用户列表搜索条件")
public class UserSelectVo extends PageParamVO {

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户邮箱")
    private String email;

    @ApiModelProperty("用户电话")
    private String mobel;

    public UserSelectVo() {
    }

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
