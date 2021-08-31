package com.crledu.auto.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 ************************************************************
 * @Description: 用户展示信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/17 16:09
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel
public class ViewUserDto {

    /**
     * 用户主键
     */
    @NotNull
    @ApiModelProperty(value="用户主键",required = true)
    private Long id;

    /**
     * 用户姓名
     */
    @ApiModelProperty(value="用户姓名")
    private String name;

    /**
     * 用户头像
     */
    @ApiModelProperty(value="用户头像")
    private String profile;

    private Integer type;



    public ViewUserDto() {
    }

    public ViewUserDto(Long id, String name, String profile) {
        this.id = id;
        this.name = name;
        this.profile = profile;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
