package com.crledu.auto.material.infrared.biz.domain;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波红外兼容材料
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredMaterialDomain {

    /**
     * 红外反射微波透射层
     */
    private ProjectionLayerDomain projectionLayerDomain;
    /**
     * 微波吸收层
     */
    private List<MicrowaveAbsorbingLayerDomain> microwaveAbsorbingLayerDomainList;

    /**
     * 微波吸收层统一周期
     */
    private Float period;
}
