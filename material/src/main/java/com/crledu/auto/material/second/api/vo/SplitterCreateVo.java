package com.crledu.auto.material.second.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("偏振分束功能波导创建表单")
public class SplitterCreateVo {

    /**
     * 结构宽度
     */
    @ApiModelProperty("结构宽度")
    private Integer width;

    /**
     * 结构高度
     */
    @ApiModelProperty("结构高度")
    private Integer height;

    /**
     * 结构材料
     */
    @ApiModelProperty("结构材料")
    private String material;

    public SplitterCreateVo() {
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
