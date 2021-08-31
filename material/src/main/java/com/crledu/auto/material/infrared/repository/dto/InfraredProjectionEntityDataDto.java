package com.crledu.auto.material.infrared.repository.dto;

import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 红外反射微波透射实体数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 14:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredProjectionEntityDataDto {

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    private Float baseDielectric;

    /**
     * 基底红外发射率
     */
    private Float baseEmissivity;

    /**
     * 金属贴片层材料
     */
    private String patchMaterial;

    /**
     * 金属贴片红外发射率
     */
    private Float patchEmissivity;

    /**
     * 金属贴片周期
     */
    private Float patchPeriod;

    /**
     * 金属贴片宽度
     */
    private Float patchWidth;

    /**
     * 金属贴片占空比
     */
    private Float patchPercent;

    /**
     * 透射层红外发射率
     */
    private Float emissivity;

    /**
     * 原始数据主键
     */
    private Long importId;

    /**
     * 入射角
     */
    private Float lightAngle;

    /**
     * 数据来源类型
     */
    private Integer dataFrom;

    /**
     * 透射指标数据文件
     */
    private List<ProjectionDataItemDto> projectionData;

    /**
     * 当前数据类型
     */
    private Integer curStatus;

    public InfraredProjectionEntityDataDto() {
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseDielectric() {
        return baseDielectric;
    }

    public void setBaseDielectric(Float baseDielectric) {
        this.baseDielectric = baseDielectric;
    }

    public Float getBaseEmissivity() {
        return baseEmissivity;
    }

    public void setBaseEmissivity(Float baseEmissivity) {
        this.baseEmissivity = baseEmissivity;
    }

    public String getPatchMaterial() {
        return patchMaterial;
    }

    public void setPatchMaterial(String patchMaterial) {
        this.patchMaterial = patchMaterial;
    }

    public Float getPatchEmissivity() {
        return patchEmissivity;
    }

    public void setPatchEmissivity(Float patchEmissivity) {
        this.patchEmissivity = patchEmissivity;
    }

    public Float getPatchPeriod() {
        return patchPeriod;
    }

    public void setPatchPeriod(Float patchPeriod) {
        this.patchPeriod = patchPeriod;
    }

    public Float getPatchWidth() {
        return patchWidth;
    }

    public void setPatchWidth(Float patchWidth) {
        this.patchWidth = patchWidth;
    }

    public Float getPatchPercent() {
        return patchPercent;
    }

    public void setPatchPercent(Float patchPercent) {
        this.patchPercent = patchPercent;
    }

    public Float getEmissivity() {
        return emissivity;
    }

    public void setEmissivity(Float emissivity) {
        this.emissivity = emissivity;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public List<ProjectionDataItemDto> getProjectionData() {
        return projectionData;
    }

    public void setProjectionData(List<ProjectionDataItemDto> projectionData) {
        this.projectionData = projectionData;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
