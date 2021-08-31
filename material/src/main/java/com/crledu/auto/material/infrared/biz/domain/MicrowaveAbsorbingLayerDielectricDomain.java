package com.crledu.auto.material.infrared.biz.domain;

/**
 ************************************************************
 * @Description: 微波吸收层介质层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:16
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsorbingLayerDielectricDomain extends MaterialLayerDomain{
    protected MicrowaveAbsorbingLayerDielectricDomain(String material, Float thickness, Float dielectricConstant) {
        super(material, thickness, dielectricConstant);
    }

    public static MicrowaveAbsorbingLayerDielectricDomain getInstance(String material, Float thickness, Float dielectricConstant){
        return new MicrowaveAbsorbingLayerDielectricDomain(material, thickness, dielectricConstant);
    }
}
