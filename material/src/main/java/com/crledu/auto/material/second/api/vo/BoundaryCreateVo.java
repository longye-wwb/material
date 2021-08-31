package com.crledu.auto.material.second.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 边界优化超透镜导入表单参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("边界优化超透镜导入表单参数")
public class BoundaryCreateVo {

    /**
     * 偏振类型：1、x偏振；2、y偏振
     */
    @ApiModelProperty("偏振类型：1、x偏振；2、y偏振")
    private Integer type;

    /**
     * 纳米天线结构类型：1、方形
     */
    @ApiModelProperty("纳米天线结构类型：1、方形")
    private Integer shape;

    /**
     * 纳米天线介电常数
     */
    @ApiModelProperty("纳米天线介电常数")
    private Float constant;

    /**
     * 基底结构类型：1、正方形
     */
    @ApiModelProperty("基底结构类型：1、正方形")
    private Integer baseShape;

    /**
     * 基底介电常数
     */
    @ApiModelProperty("基底介电常数")
    private Float baseConstant;

    /**
     * 入射光源
     */
    @ApiModelProperty("入射光源")
    private Integer lightType;

    /**
     * 入射角
     */
    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    /**
     * 工作波长
     */
    @ApiModelProperty("工作波长")
    private Float workingWave;

    /**
     * 工作方式
     */
    @ApiModelProperty(value ="工作方式")
    private Integer workType;

    /**
     * 焦距
     */
    @ApiModelProperty("焦距")
    private Float focalLength;

    /**
     * 全模结构边长
     */
    @ApiModelProperty("全模结构边长")
    private Float length;

    /**
     * 衍射效率
     */
    @ApiModelProperty("衍射效率")
    private Float diffractionEfficiency;

    /**
     * 聚焦效率
     */
    @ApiModelProperty("聚焦效率")
    private Float focalEfficiency;

    /**
     * 理想衍射效率
     */
    @ApiModelProperty("理想衍射效率")
    private Float hopefulDiffractionEfficiency;

    /**
     * 理想聚焦效率
     */
    @ApiModelProperty("理想聚焦效率")
    private Float hopefulFocalEfficiency;

    /**
     * 器件透过率
     */
    @ApiModelProperty("器件透过率")
    private Float Transmittance;

    public BoundaryCreateVo() {
    }

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }

    public Float getConstant() {
        return constant;
    }

    public void setConstant(Float constant) {
        this.constant = constant;
    }

    public Integer getBaseShape() {
        return baseShape;
    }

    public void setBaseShape(Integer baseShape) {
        this.baseShape = baseShape;
    }

    public Float getBaseConstant() {
        return baseConstant;
    }

    public void setBaseConstant(Float baseConstant) {
        this.baseConstant = baseConstant;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Double lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Float getWorkingWave() {
        return workingWave;
    }

    public void setWorkingWave(Float workingWave) {
        this.workingWave = workingWave;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Float getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(Float focalLength) {
        this.focalLength = focalLength;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getDiffractionEfficiency() {
        return diffractionEfficiency;
    }

    public void setDiffractionEfficiency(Float diffractionEfficiency) {
        this.diffractionEfficiency = diffractionEfficiency;
    }

    public Float getFocalEfficiency() {
        return focalEfficiency;
    }

    public void setFocalEfficiency(Float focalEfficiency) {
        this.focalEfficiency = focalEfficiency;
    }

    public Float getHopefulDiffractionEfficiency() {
        return hopefulDiffractionEfficiency;
    }

    public void setHopefulDiffractionEfficiency(Float hopefulDiffractionEfficiency) {
        this.hopefulDiffractionEfficiency = hopefulDiffractionEfficiency;
    }

    public Float getHopefulFocalEfficiency() {
        return hopefulFocalEfficiency;
    }

    public void setHopefulFocalEfficiency(Float hopefulFocalEfficiency) {
        this.hopefulFocalEfficiency = hopefulFocalEfficiency;
    }

    public Float getTransmittance() {
        return Transmittance;
    }

    public void setTransmittance(Float transmittance) {
        Transmittance = transmittance;
    }
}
