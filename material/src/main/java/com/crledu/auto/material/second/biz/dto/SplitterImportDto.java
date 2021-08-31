package com.crledu.auto.material.second.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;
import io.swagger.annotations.ApiModelProperty;

public class SplitterImportDto extends ImportItemFormData {

    /**
     * 结构宽度
     */
    private Integer width;

    /**
     * 结构高度
     */
    private Integer height;

    /**
     * 结构材料
     */
    private String material;

    public SplitterImportDto() {
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
