package com.crledu.auto.material.antenna.repository.dto;

import com.crledu.auto.material.antenna.biz.dto.AntennaDataItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 纳米天线基础数据的内容
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 11:13
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AntennaEntityDataDto {

    /**
     * 天线材料
     */
    private String material;

    /**
     * 天线介电常数
     */
    private Float constant;

    /**
     * 天线类型
     */
    private Integer type;

    /**
     * 天线半径
     */
    private Float radius;

    /**
     * 天线高度
     */
    private Float height;

    /**
     * 天线长轴
     */
    private Float longAxis;

    /**
     * 天线短轴
     */
    private Float minorAxis;

    /**
     * 基底类型
     */
    private Integer baseType;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    private Float baseConstant;

    /**
     * 基底厚度
     */
    private Float baseThickness;

    /**
     * 基底边长
     */
    private Float baseSide;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 光源类型
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 工作方式
     */
    private Integer workingMode;

    /**
     * 导入历史主键
     */
    private Long importId;

    /**
     * 曲线数据内容
     */
    private List<AntennaDataItemDto> dataArray;

    private Float eff;

    public AntennaEntityDataDto() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getConstant() {
        return constant;
    }

    public void setConstant(Float constant) {
        this.constant = constant;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseConstant() {
        return baseConstant;
    }

    public void setBaseConstant(Float baseConstant) {
        this.baseConstant = baseConstant;
    }

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
    }

    public Float getBaseSide() {
        return baseSide;
    }

    public void setBaseSide(Float baseSide) {
        this.baseSide = baseSide;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public List<AntennaDataItemDto> getDataArray() {
        return dataArray;
    }

    public void setDataArray(List<AntennaDataItemDto> dataArray) {
        this.dataArray = dataArray;
    }

    public Integer getBaseType() {
        return baseType;
    }

    public void setBaseType(Integer baseType) {
        this.baseType = baseType;
    }

    public Float getEff() {
        return eff;
    }

    public void setEff(Float eff) {
        this.eff = eff;
    }
}
