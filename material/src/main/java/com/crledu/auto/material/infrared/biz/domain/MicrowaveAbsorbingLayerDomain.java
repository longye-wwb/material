package com.crledu.auto.material.infrared.biz.domain;

/**
 ************************************************************
 * @Description: 微波吸收层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:12
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingLayerDomain {

    private MicrowaveAbsorbingLayerDielectricDomain dielectricDomain;
    private MicrowaveAbsorbingLayerBaseDomain baseDomain;
    private MicrowaveAbsorbingLayerFilmResistanceDomain filmResistanceDomain;

    protected MicrowaveAbsorbingLayerDomain(Integer shape,Float sideLength,Float resistanceVale,String baseMaterial,Float baseDielectric,String dielectricMaterial,Float dielectricConstant,Float dielectricThickness){
        this.baseDomain = MicrowaveAbsorbingLayerBaseDomain.getInstance(baseMaterial,baseDielectric);
        this.dielectricDomain = MicrowaveAbsorbingLayerDielectricDomain.getInstance(dielectricMaterial,dielectricThickness,dielectricConstant);
        this.filmResistanceDomain = MicrowaveAbsorbingLayerFilmResistanceDomain.getInstance(shape,sideLength,resistanceVale);
    }

    public static MicrowaveAbsorbingLayerDomain getInstance(Integer shape,Float sideLength,Float resistanceVale,String baseMaterial,Float baseDielectric,String dielectricMaterial,Float dielectricConstant,Float dielectricThickness){
        return new MicrowaveAbsorbingLayerDomain(shape, sideLength, resistanceVale, baseMaterial, baseDielectric, dielectricMaterial, dielectricConstant, dielectricThickness);
    }

    public MicrowaveAbsorbingLayerDielectricDomain getDielectricDomain() {
        return dielectricDomain;
    }

    public MicrowaveAbsorbingLayerBaseDomain getBaseDomain() {
        return baseDomain;
    }

    public MicrowaveAbsorbingLayerFilmResistanceDomain getFilmResistanceDomain() {
        return filmResistanceDomain;
    }
}
