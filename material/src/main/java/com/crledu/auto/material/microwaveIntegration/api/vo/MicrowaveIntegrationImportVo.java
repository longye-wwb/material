package com.crledu.auto.material.microwaveIntegration.api.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class MicrowaveIntegrationImportVo {

    @ApiModelProperty("入射光类型")
    private Integer lightType;
    //入射角度
    @ApiModelProperty("入射光角度")
    private Float lightAngle;
    //工作方式
    @ApiModelProperty("工作方式")
    private Integer workType;
    //介电常数
    @ApiModelProperty("介电常数")
    private Float dielectric;
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("方形环周期")
    private Float p;

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public void setDielectric(Float dielectric) {
        this.dielectric = dielectric;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
    }
}
