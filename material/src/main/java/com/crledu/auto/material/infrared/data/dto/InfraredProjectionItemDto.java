package com.crledu.auto.material.infrared.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 红外微波透射一体化数据搜索单项
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 18:09
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("红外微波透射一体化数据项")
public class InfraredProjectionItemDto {

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("对应导入历史")
    private Long importId;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;
    /**
     * 基底材料
     */
    @ApiModelProperty("基底材料")
    private String baseMaterial;

    /**
     * 基底介电常数
     */
    @ApiModelProperty("基底介电常数")
    private Float baseDielectric;

    /**
     * 基底红外发射率
     */
    @ApiModelProperty("基底红外发射率")
    private Float baseEmissivity;

    /**
     * 基底厚度
     */
    @ApiModelProperty("基底厚度")
    private Float baseThickness;

    /**
     * 金属贴片层材料
     */
    @ApiModelProperty("贴片材料")
    private String patchMaterial;

    /**
     * 金属贴片红外发射率
     */
    @ApiModelProperty("贴片红外发射率")
    private Float patchEmissivity;

    /**
     * 金属贴片周期
     */
    @ApiModelProperty("贴片周期")
    private Float patchPeriod;

    /**
     * 金属贴片宽度
     */
    @ApiModelProperty("贴片宽度")
    private Float patchWidth;

    /**
     * 金属贴片占空比
     */
    @ApiModelProperty("贴片占空比")
    private Float patchPercent;

    /**
     * 透射层红外发射率
     */
    @ApiModelProperty("整体红外发射率")
    private Float emissivity;

    /**
     * 入射角
     */
    @ApiModelProperty("入射角")
    private Float lightAngle;

    public InfraredProjectionItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
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

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }
}
