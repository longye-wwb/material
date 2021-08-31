package com.crledu.auto.material.cooling.repository.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 ************************************************************
 * @Description: 辐射制冷数据实体
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/13 9:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@TableName("at_cooling_mate")
public class CoolingMaterailEntity {

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 导入历史主键
     */
    private Long importId;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 结构类型：1、镀膜结构；2、两层圆柱
     */
    private Integer type;

    /**
     * 厚度
     */
    private Float thickness;

    /**
     * 周期
     */
    private Float period;

    /**
     * 基底参数
     */
    private String base;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 分层数据
     */
    private String layer;

    /**
     * 总层数
     */
    private Integer layerAmount;

    /**
     * 奇数层材料
     */
    private String firstMaterial;

    /**
     * 偶数层材料
     */
    private String secondMaterial;

    /**
     * 入射光源类型
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
     * 吸收率
     */
    private String absorptivity;

    /**
     * 波长
     */
    private Float maxWavelength;
    private Float minWavelength;

    public CoolingMaterailEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
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

    public String getAbsorptivity() {
        return absorptivity;
    }

    public void setAbsorptivity(String absorptivity) {
        this.absorptivity = absorptivity;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
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

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public Integer getLayerAmount() {
        return layerAmount;
    }

    public void setLayerAmount(Integer layerAmount) {
        this.layerAmount = layerAmount;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Float getMaxWavelength() {
        return maxWavelength;
    }

    public void setMaxWavelength(Float maxWavelength) {
        this.maxWavelength = maxWavelength;
    }

    public Float getMinWavelength() {
        return minWavelength;
    }

    public void setMinWavelength(Float minWavelength) {
        this.minWavelength = minWavelength;
    }
}
