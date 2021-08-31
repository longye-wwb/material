package com.crledu.auto.material.infrared.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;

/**
 ************************************************************
 * @Description: 红外反射微波投射层表单数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 12:16
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredProjectionFormdataDto extends ImportItemFormData {

    private Float lightAngle;

    private String patchMaterial;
    private String baseMaterial;
    private Float baseInfraredEmissivity;
    private Float patchInfraredEmissivity;
    private Float patchThickness;
    private Float baseThickness;
    private Float baseElectric;

    public InfraredProjectionFormdataDto() {
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
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
