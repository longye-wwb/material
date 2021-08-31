package com.crledu.auto.system.dto;

/**
 ************************************************************
 * @Description: 系统组织
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/27 16:13
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ViewOrgDto {

    /**
     * 组织主键
     */
    private Long id;

    /**
     * 组织名称
     */
    private String name;

    public ViewOrgDto() {
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
}
