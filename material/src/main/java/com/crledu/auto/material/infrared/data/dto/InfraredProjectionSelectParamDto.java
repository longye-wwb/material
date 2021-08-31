package com.crledu.auto.material.infrared.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import com.crledu.auto.web.vo.StringParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 红外微波一体化数据筛选参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 18:16
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("筛选参数")
public class InfraredProjectionSelectParamDto extends PageParamVO {

    @ApiModelProperty("基底材料")
    private StringParamVo baseMaterial;

    @ApiModelProperty("贴片材料")
    private StringParamVo patchMaterial;

    @ApiModelProperty("基底介电常数")
    private FloatParamVo baseConstant;

    @ApiModelProperty("基底材料")
    private FloatParamVo baseEmissivity;

    @ApiModelProperty("贴片周期")
    private FloatParamVo patchPeriod;

    @ApiModelProperty("贴片宽度")
    private FloatParamVo patchWidth;

    @ApiModelProperty("周期")
    private FloatParamVo percent;

    @ApiModelProperty("基底厚度")
    private FloatParamVo baseThickness;

    @ApiModelProperty("贴片厚度")
    private FloatParamVo patchThickness;

    @ApiModelProperty("贴片红外发射率")
    private FloatParamVo patchEmissivity;

    @ApiModelProperty("投射层红外发射率")
    private FloatParamVo emissivity;

    public InfraredProjectionSelectParamDto() {
    }

    public StringParamVo getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(StringParamVo baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public StringParamVo getPatchMaterial() {
        return patchMaterial;
    }

    public void setPatchMaterial(StringParamVo patchMaterial) {
        this.patchMaterial = patchMaterial;
    }

    public FloatParamVo getBaseConstant() {
        return baseConstant;
    }

    public void setBaseConstant(FloatParamVo baseConstant) {
        this.baseConstant = baseConstant;
    }

    public FloatParamVo getBaseEmissivity() {
        return baseEmissivity;
    }

    public void setBaseEmissivity(FloatParamVo baseEmissivity) {
        this.baseEmissivity = baseEmissivity;
    }

    public FloatParamVo getPatchPeriod() {
        return patchPeriod;
    }

    public void setPatchPeriod(FloatParamVo patchPeriod) {
        this.patchPeriod = patchPeriod;
    }

    public FloatParamVo getPatchWidth() {
        return patchWidth;
    }

    public void setPatchWidth(FloatParamVo patchWidth) {
        this.patchWidth = patchWidth;
    }

    public FloatParamVo getPercent() {
        return percent;
    }

    public void setPercent(FloatParamVo percent) {
        this.percent = percent;
    }

    public FloatParamVo getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(FloatParamVo baseThickness) {
        this.baseThickness = baseThickness;
    }

    public FloatParamVo getPatchThickness() {
        return patchThickness;
    }

    public void setPatchThickness(FloatParamVo patchThickness) {
        this.patchThickness = patchThickness;
    }

    public FloatParamVo getPatchEmissivity() {
        return patchEmissivity;
    }

    public void setPatchEmissivity(FloatParamVo patchEmissivity) {
        this.patchEmissivity = patchEmissivity;
    }

    public FloatParamVo getEmissivity() {
        return emissivity;
    }

    public void setEmissivity(FloatParamVo emissivity) {
        this.emissivity = emissivity;
    }
}
