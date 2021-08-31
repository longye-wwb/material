package com.crledu.auto.material.infrared.api.vo;

import com.crledu.auto.material.base.vo.ImportFormdataVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波红外一体化导入表单
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 10:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波红外一体化导入表单")
public class InfraredProjectionImportFormVo extends ImportFormdataVo {

    @ApiModelProperty("金属贴片材料")
    private String patchMaterial;

    @ApiModelProperty("基底材料")
    private String baseMaterial;

    @ApiModelProperty("基底红外发射率")
    private Float baseInfraredEmissivity;

    @ApiModelProperty("金属贴片红外发射率")
    private Float patchInfraredEmissivity;

    @ApiModelProperty("金属贴片厚度")
    private Float patchThickness;

    @ApiModelProperty("基底厚度")
    private Float baseThickness;

    @ApiModelProperty("基底介电常数")
    private Float baseElectric;

    public InfraredProjectionImportFormVo() {
        super();
    }

    public String getPatchMaterial() {
        return patchMaterial;
    }

    public void setPatchMaterial(String patchMaterial) {
        this.patchMaterial = patchMaterial;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseInfraredEmissivity() {
        return baseInfraredEmissivity;
    }

    public void setBaseInfraredEmissivity(Float baseInfraredEmissivity) {
        this.baseInfraredEmissivity = baseInfraredEmissivity;
    }

    public Float getPatchInfraredEmissivity() {
        return patchInfraredEmissivity;
    }

    public void setPatchInfraredEmissivity(Float patchInfraredEmissivity) {
        this.patchInfraredEmissivity = patchInfraredEmissivity;
    }

    public Float getPatchThickness() {
        return patchThickness;
    }

    public void setPatchThickness(Float patchThickness) {
        this.patchThickness = patchThickness;
    }

    public Float getBaseThickness() {
        return baseThickness;
    }

    public void setBaseThickness(Float baseThickness) {
        this.baseThickness = baseThickness;
    }

    public Float getBaseElectric() {
        return baseElectric;
    }

    public void setBaseElectric(Float baseElectric) {
        this.baseElectric = baseElectric;
    }
}
