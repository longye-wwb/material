package com.crledu.auto.material.infrared.biz.domain;

import com.crledu.auto.material.infrared.biz.dto.AbsorbingDataItemDto;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收层导入数据业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:52
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAbsordingLayerImportDataDomain {

    /**
     * 数据主键
     */
    private Long id;

    /**
     * 导入历史主键
     */
    private Long importId;

    /**
     * 内部层级结构
     */
    private List<MicrowaveAbsorbingLayerDomain> microwaveAbsorbingLayerDomainList;

    /**
     * 微波吸收层周期
     */
    private Float period;

    /**
     * 数据来源
     */
    private Integer dataFrom;

    /**
     * 入射角
     */
    private Float lightFrom;

    /**
     * 吸收率参数
     */
    private List<AbsorbingDataItemDto> absorbingData;

    private Boolean saveData;

    protected MicrowaveAbsordingLayerImportDataDomain(Long importId, List<MicrowaveAbsorbingLayerDomain> microwaveAbsorbingLayerDomainList, Float period, Integer dataFrom, Float lightFrom, List<AbsorbingDataItemDto> absorbingData,Boolean saveData) {
        this.importId = importId;
        this.microwaveAbsorbingLayerDomainList = microwaveAbsorbingLayerDomainList;
        this.period = period;
        this.dataFrom = dataFrom;
        this.lightFrom = lightFrom;
        this.absorbingData = absorbingData;
        this.saveData = saveData;
    }

    public static MicrowaveAbsordingLayerImportDataDomain getInstance(Long importId, List<MicrowaveAbsorbingLayerDomain> microwaveAbsorbingLayerDomainList, Float period, Integer dataFrom, Float lightFrom, List<AbsorbingDataItemDto> absorbingData,Boolean saveData){
        return new MicrowaveAbsordingLayerImportDataDomain(importId, microwaveAbsorbingLayerDomainList, period, dataFrom, lightFrom, absorbingData,saveData);
    }

    public Long getId() {
        return id;
    }

    public Long getImportId() {
        return importId;
    }

    public List<MicrowaveAbsorbingLayerDomain> getMicrowaveAbsorbingLayerDomainList() {
        return microwaveAbsorbingLayerDomainList;
    }

    public Float getPeriod() {
        return period;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public Float getLightFrom() {
        return lightFrom;
    }

    public List<AbsorbingDataItemDto> getAbsorbingData() {
        return absorbingData;
    }

    public Boolean getSaveData() {
        return saveData;
    }
}
