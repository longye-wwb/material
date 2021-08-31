package com.crledu.auto.material.infrared.biz.domain;

/**
 ************************************************************
 * @Description: 微波吸收层基底
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:14
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingLayerBaseDomain extends MaterialLayerDomain{
    protected MicrowaveAbsorbingLayerBaseDomain(String material, Float thickness, Float dielectricConstant) {
        super(material, thickness, dielectricConstant);
    }

    public static MicrowaveAbsorbingLayerBaseDomain getInstance(String material, Float dielectricConstant){
        return new MicrowaveAbsorbingLayerBaseDomain(material,null,dielectricConstant);
    }
}
