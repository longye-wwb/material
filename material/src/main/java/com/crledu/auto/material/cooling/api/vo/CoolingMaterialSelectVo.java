package com.crledu.auto.material.cooling.api.vo;

import com.crledu.auto.web.view.PageParamVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 ************************************************************
 * @Description: 辐射制冷材料选择条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 16:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("辐射制冷材料选择条件")
public class CoolingMaterialSelectVo extends PageParamVO {

    @ApiModelProperty("类型：1、多层膜；2、两层圆柱")
    private Integer type;
    @ApiModelProperty("基底材料")
    private String baseMaterial;
    @ApiModelProperty("奇数层材料")
    private String firstMaterial;
    @ApiModelProperty("偶数层材料")
    private String secondMaterial;
    @ApiModelProperty("总厚度")
    private Float thickness;
    @ApiModelProperty("总层数")
    private Integer layers;
    @ApiModelProperty("光源类型")
    private Integer lightType;
    @ApiModelProperty("入射角")
    private Float lightAngle;
    @ApiModelProperty("工作方式")
    private Integer workingMode;
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    public CoolingMaterialSelectVo() {
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
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

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Integer getLayers() {
        return layers;
    }

    public void setLayers(Integer layers) {
        this.layers = layers;
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

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }
}
