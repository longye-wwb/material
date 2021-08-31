package com.crledu.auto.material.cooling.biz.dto;

import com.crledu.auto.web.view.PageParamVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 辐射制冷材料筛选条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 16:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("辐射制冷材料筛选条件")
public class CoolingMaterialSelectDto extends PageParamVO {


    private Integer type;
    @ApiModelProperty(value = "基底材料")
    private String baseMaterial;
    @ApiModelProperty(value = "奇数层材料")
    private String firstMaterial;
    @ApiModelProperty(value = "偶数层材料")
    private String secondMaterial;
    @ApiModelProperty(value = "总厚度")
    private Float thickness;
    @ApiModelProperty(value = "总层数")
    private Integer layers;
    @ApiModelProperty(value = "入射光源类型")
    private Integer lightType;
    @ApiModelProperty(value ="入射光源角度")
    private Float lightAngle;
    @ApiModelProperty(value ="工作方式")
    private Integer workingMode;
    @ApiModelProperty(value = "数据来源")
    private Integer dataFrom;

    public CoolingMaterialSelectDto() {
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
