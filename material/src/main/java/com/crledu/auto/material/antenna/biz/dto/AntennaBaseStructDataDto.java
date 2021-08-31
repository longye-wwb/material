package com.crledu.auto.material.antenna.biz.dto;

/**
 ************************************************************
 * @Description: 天线基底结构综合数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 11:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AntennaBaseStructDataDto {

    private String material;
    private Integer type;
    private Float constant;
    private Float thickness;
    private Float side;

    public AntennaBaseStructDataDto() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getConstant() {
        return constant;
    }

    public void setConstant(Float constant) {
        this.constant = constant;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Float getSide() {
        return side;
    }

    public void setSide(Float side) {
        this.side = side;
    }
}
