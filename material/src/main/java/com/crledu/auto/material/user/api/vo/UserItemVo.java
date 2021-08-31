package com.crledu.auto.material.user.api.vo;

import com.crledu.auto.material.user.biz.dto.UserItemDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("用户基础信息")
public class UserItemVo {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 用户姓名
     */
    @ApiModelProperty("用户姓名")
    private String name;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    private String profile;

    /**
     * 用户手机
     */
    @ApiModelProperty("用户手机")
    private String mobel;

    /**
     * 用户邮箱
     */
    @ApiModelProperty("用户邮箱")
    private String email;

    /**
     * 用户生日
     */
    @ApiModelProperty("用户生日")
    private Date borthday;

    private Integer status;

    public UserItemVo() {
    }

    public UserItemVo(UserItemDto itemDto) {
        this.id = itemDto.getId();
        this.borthday = itemDto.getBorthday();
        this.email = itemDto.getEmail();
        this.mobel = itemDto.getMobel();
        this.name = itemDto.getName();
        this.profile = itemDto.getProfile();
        this.status = itemDto.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBorthday() {
        return borthday;
    }

    public void setBorthday(Date borthday) {
        this.borthday = borthday;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
