package com.crledu.auto.material.infrared.api.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/1
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveAbsorbingVo {

    @ApiModelProperty(value = "数据库主键")
    private Long id;

    @ApiModelProperty(value ="透射层周期")
    private Float period;

    /**
     * 数据来源
     */
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;

    /**
     * 入射角
     */
    @ApiModelProperty(value = "入射角")
    private Float lightAngle;

    /**
     * 吸收率数据
     */
    @ApiModelProperty(value = "吸收率数据")
    private String absorbingData;

    /**
     * 数据状态
     */
    @ApiModelProperty(value = "数据状态")
    private Integer curStatus;

    private List<MicrowaveAbsorbingLayerVo> layerVos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public String getAbsorbingData() {
        return absorbingData;
    }

    public void setAbsorbingData(String absorbingData) {
        this.absorbingData = absorbingData;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    public List<MicrowaveAbsorbingLayerVo> getLayerVos() {
        return layerVos;
    }

    public void setLayerVos(List<MicrowaveAbsorbingLayerVo> layerVos) {
        this.layerVos = layerVos;
    }
}
