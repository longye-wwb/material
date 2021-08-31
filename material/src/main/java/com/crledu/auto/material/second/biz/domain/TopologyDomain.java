package com.crledu.auto.material.second.biz.domain;

import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.dto.ImportItemFormData;

/**
 ************************************************************
 * @Description: 拓扑优化超透镜业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 13:43
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class TopologyDomain extends AbstructImportDomain {

    private Long id;

    /**
     * 天线材料
     */
    private String material;

    /**
     * 天线高度
     */
    private Float height;

    /**
     * 图形宽度
     */
    private Float width;

    /**
     * 图形长度
     */
    private Float length;

    /**
     * 基底材料
     */
    private String baseMaterial;

    /**
     * 基底结构参数
     */
    private Float baseStruct;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射光源
     */
    private Integer lightType;

    /**
     * 入射角
     */
    private Double lightAngle;

    /**
     * 数据孔径
     */
    private Float aperture;

    /**
     * 工作方式
     */
    private Integer workType;

    /**
     * 聚焦效率
     */
    private Float focalEfficiency;

    /**
     * 图形结构
     */
    private String geometry;

    public TopologyDomain(ImportItemFormData importItemFormData) {
        super(importItemFormData);
    }
}
