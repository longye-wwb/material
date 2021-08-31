package com.crledu.auto.material.infrared.biz.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description:
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/1
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveAbsorbingSelectDto {

    /**
     * 透射层周期
     */
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

    private Integer pageSize;

    private Integer pageNum;

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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
