package com.crledu.auto.material.infrared.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 红外反射微波透射层导入表单数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 10:43
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("红外反射微波透射层导入表单数据")
public class ProjectionLayerImportVo {

    @ApiModelProperty("金属贴片材料")
    private String PatchMaterial;

    @ApiModelProperty("贴片层红外发射率")
    private Float patchEmissivity;

    @ApiModelProperty("基底材料")
    private String baseMaterial;

    @ApiModelProperty("基底介电常数")
    private Float baseDielectric;

    @ApiModelProperty("基底红外发射率")
    private Float baseEmissivity;

    @ApiModelProperty("介质层材料")
    private String dielectricMaterial;

    @ApiModelProperty("介质层介电常数")
    private Float dielectricConstant;

    @ApiModelProperty("介质层红外发射率")
    private Float dielectricEmissivity;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("入射角")
    private Float lightAngle;

    public ProjectionLayerImportVo() {
    }

    public String getPatchMaterial() {
        return PatchMaterial;
    }

    public void setPatchMaterial(String patchMaterial) {
        PatchMaterial = patchMaterial;
    }

    public Float getPatchEmissivity() {
        return patchEmissivity;
    }

    public void setPatchEmissivity(Float patchEmissivity) {
        this.patchEmissivity = patchEmissivity;
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

    public Float getDielectricEmissivity() {
        return dielectricEmissivity;
    }

    public void setDielectricEmissivity(Float dielectricEmissivity) {
        this.dielectricEmissivity = dielectricEmissivity;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }
}
