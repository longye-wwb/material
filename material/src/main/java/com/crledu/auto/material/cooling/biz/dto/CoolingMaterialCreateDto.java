package com.crledu.auto.material.cooling.biz.dto;

import java.util.List;

/**
 ************************************************************
 * @Description: 辐射制冷材料创建参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 11:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CoolingMaterialCreateDto {

    /**
     * 导入历史主键
     */
    private Long importId;

    /**
     * 辐射制冷材料类型
     */
    private Integer type;

    /**
     * 层数
     */
    private Integer layers;

    /**
     * 奇数层材料
     */
    private String firstMaterial;

    /**
     * 偶数层材料
     */
    private String secondMaterial;

    /**
     * 厚度参数数组
     */
    private List<Float> thicknessList;

    /**
     * 直径参数
     */
    private List<Float> diameterList;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 周期
     */
    private Float period;

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
     * 吸收率数组
     */
    private List<AbsorbingItemDto> absorbingItemDtos;

    public CoolingMaterialCreateDto() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLayers() {
        return layers;
    }

    public void setLayers(Integer layers) {
        this.layers = layers;
    }

    public String getFirstMaterial() {
        return firstMaterial;
    }

    public void setFirstMaterial(String firstMaterial) {
        this.firstMaterial = firstMaterial;
    }

    public String getSecondMaterial() {
        return secondMaterial;
    }

    public void setSecondMaterial(String secondMaterial) {
        this.secondMaterial = secondMaterial;
    }

    public List<Float> getThicknessList() {
        return thicknessList;
    }

    public void setThicknessList(List<Float> thicknessList) {
        this.thicknessList = thicknessList;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
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

    public List<AbsorbingItemDto> getAbsorbingItemDtos() {
        return absorbingItemDtos;
    }

    public void setAbsorbingItemDtos(List<AbsorbingItemDto> absorbingItemDtos) {
        this.absorbingItemDtos = absorbingItemDtos;
    }

    public List<Float> getDiameterList() {
        return diameterList;
    }

    public void setDiameterList(List<Float> diameterList) {
        this.diameterList = diameterList;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }
}
