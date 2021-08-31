package com.crledu.auto.material.second.repository.dto;

import com.crledu.auto.material.second.biz.dto.LightDataItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 边界优化超透镜
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BoundaryDataDto {

    private Long id;

    /**
     * 偏振类型：1、x偏振；2、y偏振
     */
    private Integer type;

    /**
     * 纳米天线结构类型：1、方形
     */
    private Integer shape;

    /**
     * 纳米天线介电常数
     */
    private Float constant;

    /**
     * 基底结构类型：1、正方形
     */
    private Integer baseShape;

    /**
     * 基底介电常数
     */
    private Float baseConstant;

    /**
     * 天线结构长轴
     */
    private Float l;

    /**
     * 天线结构短轴
     */
    private Float w;

    /**
     * 天线结构高速
     */
    private Float h2;

    /**
     * 基底厚度
     */
    private Float h1;

    /**
     * 基底边长
     */
    private Float p;

    /**
     * 入射光源
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Double lightAngle;

    /**
     * 工作波长
     */
    private Float workingWave;

    /**
     * 工作方式
     */
    private Integer workType;

    /**
     * 焦距
     */
    private Float focalLength;

    /**
     * 全模结构边长
     */
    private Float length;

    /**
     * 衍射效率
     */
    private Float diffractionEfficiency;

    /**
     * 聚焦效率
     */
    private Float focalEfficiency;

    /**
     * 理想衍射效率
     */
    private Float hopefulDiffractionEfficiency;

    /**
     * 理想聚焦效率
     */
    private Float hopefulFocalEfficiency;

    /**
     * 器件透过率
     */
    private Float Transmittance;

    /**
     * 中心点很坐标
     */
    private Float centerX;

    /**
     * 中心点纵坐标
     */
    private Float centery;

    private List<LightDataItemDto> lightData;

    private Long importId;

    private Integer dataFrom;

    public BoundaryDataDto() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Float getL() {
        return l;
    }

    public void setL(Float l) {
        this.l = l;
    }

    public Float getW() {
        return w;
    }

    public void setW(Float w) {
        this.w = w;
    }

    public Float getH2() {
        return h2;
    }

    public void setH2(Float h2) {
        this.h2 = h2;
    }

    public Float getH1() {
        return h1;
    }

    public void setH1(Float h1) {
        this.h1 = h1;
    }

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
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

    public Float getCenterX() {
        return centerX;
    }

    public void setCenterX(Float centerX) {
        this.centerX = centerX;
    }

    public Float getCentery() {
        return centery;
    }

    public void setCentery(Float centery) {
        this.centery = centery;
    }

    public List<LightDataItemDto> getLightData() {
        return lightData;
    }

    public void setLightData(List<LightDataItemDto> lightData) {
        this.lightData = lightData;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }
}
