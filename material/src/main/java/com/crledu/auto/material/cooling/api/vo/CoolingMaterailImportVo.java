package com.crledu.auto.material.cooling.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 导入辐射制冷数据参数列表
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 9:59
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("辐射制冷导入参数")
public class CoolingMaterailImportVo {

    @ApiModelProperty("类型：1，镀膜；2、两层圆柱")
    private Integer type;

    @ApiModelProperty("基底")
    private LayerVo base;

    @ApiModelProperty("奇数层材料")
    private String firstMaterial;

    @ApiModelProperty("偶数层材料")
    private String secondMaterial;

    @ApiModelProperty("光源类型")
    private Integer lightType;

    @ApiModelProperty("入射角")
    private Float lightAngle;

    @ApiModelProperty("工作方式")
    private Integer workMode;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    public CoolingMaterailImportVo() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public LayerVo getBase() {
        return base;
    }

    public void setBase(LayerVo base) {
        this.base = base;
    }

    public String getFirstMaterial() {
        return firstMaterial;
    }

    public void setFirstMaterial(String firstMaterial) {
        this.firstMaterial = firstMaterial;
    }

    public String getSecondMaterial() {
        return secondMaterial;
    }

    public void setSecondMaterial(String secondMaterial) {
        this.secondMaterial = secondMaterial;
    }

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

    public Integer getWorkMode() {
        return workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }
}
