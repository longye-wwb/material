package com.crledu.auto.material.cooling.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 材料结构中的测
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 10:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("不同材料对应的层相关参数")
public class LayerVo {

    @ApiModelProperty("序号")
    private Integer index;

    @ApiModelProperty("材料")
    private String material;

    @ApiModelProperty("厚度")
    private Float thickness;

    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("电阻")
    private Float resistance;

    public LayerVo() {
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getResistance() {
        return resistance;
    }

    public void setResistance(Float resistance) {
        this.resistance = resistance;
    }
}
