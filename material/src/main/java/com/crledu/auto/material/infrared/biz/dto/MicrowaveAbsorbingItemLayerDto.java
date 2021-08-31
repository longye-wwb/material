package com.crledu.auto.material.infrared.biz.dto;


/**
 ************************************************************
 * @Description: 微波吸收层相关参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/25 16:12
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingItemLayerDto {

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底材料介电常数
     */
    private Float baseDielectricConstant;

    /**
     * 介质层材料
     */
    private String dielectricMaterial;

    /**
     * 介质层材料介电常数
     */
    private Float dielectricConstant;

    /**
     * 形状
     */
    private Integer shape;

    public MicrowaveAbsorbingItemLayerDto() {
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseDielectricConstant() {
        return baseDielectricConstant;
    }

    public void setBaseDielectricConstant(Float baseDielectricConstant) {
        this.baseDielectricConstant = baseDielectricConstant;
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

    public Integer getShape() {
        return shape;
    }

    public void setShape(Integer shape) {
        this.shape = shape;
    }
}
