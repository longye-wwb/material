package com.crledu.auto.material.antenna.biz.dto;

/**
 ************************************************************
 * @Description: 天线综合数据结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 11:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AntennaStructDataDto {

    private String material;
    private Integer type;
    private Float constant;
    private Float radius;
    private Float height;
    private Float longAxis;
    private Float minorAxis;

    public AntennaStructDataDto() {
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

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getLongAxis() {
        return longAxis;
    }

    public void setLongAxis(Float longAxis) {
        this.longAxis = longAxis;
    }

    public Float getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(Float minorAxis) {
        this.minorAxis = minorAxis;
    }
}
