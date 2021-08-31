package com.crledu.auto.material.antenna.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import com.crledu.auto.web.vo.StringParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 纳米天线材料筛选条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 16:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("纳米天线材料筛选")
public class AntennaSelectParamDto extends PageParamVO {

    @ApiModelProperty("天线材料")
    private StringParamVo material;

    @ApiModelProperty("天线类型")
    private Integer type;

    @ApiModelProperty("天线介电常数")
    private FloatParamVo constant;

    @ApiModelProperty("天线高度")
    private FloatParamVo height;

    @ApiModelProperty("天线半径")
    private FloatParamVo radius;

    @ApiModelProperty("天线长轴")
    private FloatParamVo longAxis;

    @ApiModelProperty("天线短轴")
    private FloatParamVo minorAxis;

    @ApiModelProperty("基底材料")
    private StringParamVo baseMaterial;

    @ApiModelProperty("基底类型")
    private Integer baseType;

    @ApiModelProperty("基底介电常数")
    private FloatParamVo baseConstant;

    @ApiModelProperty("基底高度")
    private FloatParamVo baseHeight;

    @ApiModelProperty("基底边长")
    private FloatParamVo baseSide;

    @ApiModelProperty("基底数据来源")
    private Integer dataFrom;

    @ApiModelProperty("入射角")
    private FloatParamVo lightAngle;

    @ApiModelProperty("光源类型")
    private Integer lightType;

    @ApiModelProperty("工作方式")
    private Integer workingMode;

    @ApiModelProperty("转换效率")
    private FloatParamVo eff;

    public AntennaSelectParamDto() {
    }

    public StringParamVo getMaterial() {
        return material;
    }

    public void setMaterial(StringParamVo material) {
        this.material = material;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public FloatParamVo getConstant() {
        return constant;
    }

    public void setConstant(FloatParamVo constant) {
        this.constant = constant;
    }

    public FloatParamVo getHeight() {
        return height;
    }

    public void setHeight(FloatParamVo height) {
        this.height = height;
    }

    public FloatParamVo getRadius() {
        return radius;
    }

    public void setRadius(FloatParamVo radius) {
        this.radius = radius;
    }

    public FloatParamVo getLongAxis() {
        return longAxis;
    }

    public void setLongAxis(FloatParamVo longAxis) {
        this.longAxis = longAxis;
    }

    public FloatParamVo getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(FloatParamVo minorAxis) {
        this.minorAxis = minorAxis;
    }

    public StringParamVo getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(StringParamVo baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public FloatParamVo getBaseConstant() {
        return baseConstant;
    }

    public void setBaseConstant(FloatParamVo baseConstant) {
        this.baseConstant = baseConstant;
    }

    public FloatParamVo getBaseHeight() {
        return baseHeight;
    }

    public void setBaseHeight(FloatParamVo baseHeight) {
        this.baseHeight = baseHeight;
    }

    public FloatParamVo getBaseSide() {
        return baseSide;
    }

    public void setBaseSide(FloatParamVo baseSide) {
        this.baseSide = baseSide;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public FloatParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(FloatParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public FloatParamVo getEff() {
        return eff;
    }

    public void setEff(FloatParamVo eff) {
        this.eff = eff;
    }
}
