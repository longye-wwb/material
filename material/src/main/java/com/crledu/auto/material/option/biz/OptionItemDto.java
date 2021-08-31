package com.crledu.auto.material.option.biz;

/**
 ************************************************************
 * @Description: 选项数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 12:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class OptionItemDto {

    private String code;
    private String name;
    private Long id;

    public OptionItemDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
