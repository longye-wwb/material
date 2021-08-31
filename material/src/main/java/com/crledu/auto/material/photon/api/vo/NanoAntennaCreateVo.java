package com.crledu.auto.material.photon.api.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/25
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaCreateVo {

    @ApiModelProperty(value = "纳米天线结构类型")
    private Integer topType;

    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ApiModelProperty(value = "基底结构类型")
    private Integer downType;

    @ApiModelProperty(value = "基底材料")
    private Double downConstant;

    @ApiModelProperty(value = "数据来源")
    private Integer source;

    @ApiModelProperty(value = "入射光源类型")
    private Integer lightType;

    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    @ApiModelProperty(value ="工作方式")
    private Integer workType;

    @ApiModelProperty(value = "附件")
    private String file;


    public Integer getTopType() {
        return topType;
    }

    public void setTopType(Integer topType) {
        this.topType = topType;
    }

    public Double getTopConstant() {
        return topConstant;
    }

    public void setTopConstant(Double topConstant) {
        this.topConstant = topConstant;
    }

    public Integer getDownType() {
        return downType;
    }

    public void setDownType(Integer downType) {
        this.downType = downType;
    }

    public Double getDownConstant() {
        return downConstant;
    }

    public void setDownConstant(Double downConstant) {
        this.downConstant = downConstant;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Double lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
