package com.crledu.auto.material.photon.repository.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkyDto {

    private Integer topType;

    private Double topConstant;

    private Integer downType;

    private Double downConstant;

    private Integer source;

    private Integer lightType;

    private Double lightAngle;

    private Integer workType;

    private String file;

    public PhotonSkyDto(Integer topType, Double topConstant, Integer downType, Double downConstant, Integer source, Integer lightType, Double lightAngle, Integer workType, String file) {
        this.topType = topType;
        this.topConstant = topConstant;
        this.downType = downType;
        this.downConstant = downConstant;
        this.source = source;
        this.lightType = lightType;
        this.lightAngle = lightAngle;
        this.workType = workType;
        this.file = file;
    }

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
