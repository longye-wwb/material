package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.web.exception.RestRuntimeException;

/**
 ************************************************************
 * @Description: 红外反射微波介质层
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 10:34
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionLayerDielectricDomain extends MaterialLayerDomain{

    /**
     * 红外发射率
     */
    private Float infraredEmissivity;

    protected ProjectionLayerDielectricDomain(String material, Float thickness, Float dielectricConstant,Float infraredEmissivity) {
        super(material, thickness, dielectricConstant);
        if(infraredEmissivity == null || infraredEmissivity.isNaN()){
            throw new RestRuntimeException("透射介质缺少红外发射率参数","1100000001");
        }
        this.infraredEmissivity = infraredEmissivity;
    }

    public static ProjectionLayerDielectricDomain getInstance(String material, Float thickness, Float dielectricConstant,Float infraredEmissivity){
        return new ProjectionLayerDielectricDomain(material, thickness, dielectricConstant, infraredEmissivity);
    }

    public Float getInfraredEmissivity() {
        return infraredEmissivity;
    }
}
