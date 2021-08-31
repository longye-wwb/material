package com.crledu.auto.material.second.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 拓扑优化超透镜导入参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 17:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("拓扑优化超透镜导入参数")
public class TopologyCreateVo {

    /**
     * 天线材料
     */
    @ApiModelProperty("天线材料")
    private String material;

    /**
     * 天线高度
     */
    @ApiModelProperty("天线高度")
    private Float height;

    /**
     * 图形宽度
     */
    @ApiModelProperty("图形宽度")
    private Float width;

    /**
     * 图形长度
     */
    @ApiModelProperty("图形长度")
    private Float length;

    /**
     * 基底材料
     */
    @ApiModelProperty("基底材料")
    private String baseMaterial;

    /**
     * 基底结构参数
     */
    @ApiModelProperty("基底结构参数")
    private Float baseStruct;

    /**
     * 数据来源
     */
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    /**
     * 入射光源
     */
    @ApiModelProperty("入射光源")
    private Integer lightType;

    /**
     * 入射角
     */
    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    /**
     * 数据孔径
     */
    @ApiModelProperty(value = "数据孔径")
    private Float aperture;

    /**
     * 工作方式
     */
    @ApiModelProperty(value ="工作方式")
    private Integer workType;

    /**
     * 聚焦效率
     */
    @ApiModelProperty("聚焦效率")
    private Float focalEfficiency;

    public TopologyCreateVo() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public String getBaseMaterial() {
        return baseMaterial;
    }

    public void setBaseMaterial(String baseMaterial) {
        this.baseMaterial = baseMaterial;
    }

    public Float getBaseStruct() {
        return baseStruct;
    }

    public void setBaseStruct(Float baseStruct) {
        this.baseStruct = baseStruct;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
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

    public Float getAperture() {
        return aperture;
    }

    public void setAperture(Float aperture) {
        this.aperture = aperture;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Float getFocalEfficiency() {
        return focalEfficiency;
    }

    public void setFocalEfficiency(Float focalEfficiency) {
        this.focalEfficiency = focalEfficiency;
    }
}
