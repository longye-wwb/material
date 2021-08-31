package com.crledu.auto.material.infrared.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/1
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@ApiModel("筛选条件")
public class ProjectionSelectVo extends PageParamVO {

    /**
     * 基底材料
     */
    @ApiModelProperty(value = "基底材料")
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    @ApiModelProperty(value = "基底介电常数")
    private Float baseDielectric;

    /**
     * 基底红外发射率
     */
    @ApiModelProperty(value = "基底红外发射率")
    private Float baseEmissivity;

    /**
     * 介质层材料
     */
    @ApiModelProperty(value = "介质层材料")
    private String dielectricMaterial;

    /**
     * 介质层介电常数
     */
    @ApiModelProperty(value = "介质层介电常数")
    private Float dielectricConstant;

    /**
     * 介质层厚度
     */
    @ApiModelProperty(value = "介质层厚度")
    private Float dielectricThickness;

    /**
     * 介质层红外发射率
     */
    @ApiModelProperty(value = "介质层红外发射率")
    private Float dielectricEmissivity;

    /**
     * 金属贴片层材料
     */
    @ApiModelProperty(value = "金属贴片层材料")
    private String patchMaterial;

    /**
     * 金属贴片红外发射率
     */
    @ApiModelProperty(value ="金属贴片红外发射率")
    private Float patchEmissivity;

    /**
     * 金属贴片周期
     */
    @ApiModelProperty(value = "金属贴片周期")
    private Float patchPeriod;

    /**
     * 金属贴片宽度
     */
    @ApiModelProperty(value = "金属贴片宽度")
    private Float patchWidth;

    /**
     * 金属贴片占空比
     */
    @ApiModelProperty(value = "金属贴片占空比")
    private Float patchPercent;

    /**
     * 透射层红外发射率
     */
    @ApiModelProperty(value ="透射层红外发射率")
    private Float emissivity;

    /**
     * 原始数据主键
     */
    @ApiModelProperty(value = "原始数据主键")
    private Long importId;

    /**
     * 入射角
     */
    @ApiModelProperty(value = "入射角")
    private Float lightAngle;

    /**
     * 数据来源类型
     */
    @ApiModelProperty(value = "数据来源类型")
    private Integer dataFrom;

    /**
     * 透射指标数据文件
     */
    @ApiModelProperty(value = "透射指标数据文件")
    private String projectionData;

    /**
     * 当前数据类型
     */
    @ApiModelProperty(value = "当前数据类型")
    private Integer curStatus;

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

    public String getDielectricMaterial() {
        return dielectricMaterial;
    }

    public void setDielectricMaterial(String dielectricMaterial) {
        this.dielectricMaterial = dielectricMaterial;
    }

    public Float getDielectricConstant() {
        return dielectricConstant;
    }

    public void setDielectricConstant(Float dielectricConstant) {
        this.dielectricConstant = dielectricConstant;
    }

    public Float getDielectricThickness() {
        return dielectricThickness;
    }

    public void setDielectricThickness(Float dielectricThickness) {
        this.dielectricThickness = dielectricThickness;
    }

    public Float getDielectricEmissivity() {
        return dielectricEmissivity;
    }

    public void setDielectricEmissivity(Float dielectricEmissivity) {
        this.dielectricEmissivity = dielectricEmissivity;
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

    public String getProjectionData() {
        return projectionData;
    }

    public void setProjectionData(String projectionData) {
        this.projectionData = projectionData;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }
}
