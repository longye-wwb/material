package com.crledu.auto.material.cooling.biz.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 辐射制冷材料基础数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 16:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("辐射制冷材料")
public class CoolingMaterialItemDto {

    @ApiModelProperty("主键")
    private Long id;
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("基底属性")
    private String base;
    @ApiModelProperty("材料层级结构")
    private String layer;
    @ApiModelProperty("入射角")
    private Float lightAngle;
    @ApiModelProperty("光源类型")
    private Integer lightType;
    @ApiModelProperty("工作方式")
    private Integer workingMode;
    @ApiModelProperty("厚度")
    private Float thickness;
    @ApiModelProperty("周期")
    private Float period;
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    public CoolingMaterialItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getPeriod() {
        return period;
    }

    public void setPeriod(Float period) {
        this.period = period;
    }
}
