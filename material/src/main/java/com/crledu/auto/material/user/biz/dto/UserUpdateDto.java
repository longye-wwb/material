package com.crledu.auto.material.user.biz.dto;

import java.util.Date;

/**
 ************************************************************
 * @Description: 用户信息更新
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 9:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class UserUpdateDto {

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobel;

    /**
     * 生日
     */
    private Date borthday;

    /**
     * 邮箱
     */
    private String email;

    public UserUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobel() {
        return mobel;
    }

    public void setMobel(String mobel) {
        this.mobel = mobel;
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
}
