package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.web.exception.RestRuntimeException;

/**
 ************************************************************
 * @Description: 材料层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 10:09
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MaterialLayerDomain {

    /**
     * 材料
     */
    private String material;

    /**
     * 厚度
     */
    private Float thickness;

    /**
     * 介电常数
     */
    private Float dielectricConstant;

    protected MaterialLayerDomain(String material, Float thickness, Float dielectricConstant) {
        if(material == null||material.isEmpty()){
            throw new RestRuntimeException("透射基底缺少材料参数","1100000001");
        }
        this.material = material;
        this.thickness = thickness;
        if(material == null||material.isEmpty()){
            throw new RestRuntimeException("透射基底缺少介电常数参数","1100000001");
        }
        this.dielectricConstant = dielectricConstant;
    }

    public static MaterialLayerDomain getInstance(String material, Float thickness, Float dielectricConstant){
        return new MaterialLayerDomain(material, thickness, dielectricConstant);
    }

    public String getMaterial() {
        return material;
    }

    public Float getThickness() {
        return thickness;
    }

    public Float getDielectricConstant() {
        return dielectricConstant;
    }
}
