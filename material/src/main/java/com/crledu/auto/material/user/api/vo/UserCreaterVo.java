package com.crledu.auto.material.user.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 ************************************************************
 * @Description: 账号密码创建用户
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 17:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("用户创建参数")
public class UserCreaterVo {

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号",required = true)
    @NotEmpty
    private String account;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)
    @NotEmpty
    private String passeord;

    /**
     * 名字
     */
    @ApiModelProperty(value = "名字",required = true)
    @NotEmpty
    private String name;

    /**
     * 出生日期
     */
    @ApiModelProperty(value = "出生日期")
    private Date borthday;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String profile;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobel;

    public UserCreaterVo() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasseord() {
        return passeord;
    }

    public void setPasseord(String passeord) {
        this.passeord = passeord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMobel() {
        return mobel;
    }

    public void setMobel(String mobel) {
        this.mobel = mobel;
    }
}
