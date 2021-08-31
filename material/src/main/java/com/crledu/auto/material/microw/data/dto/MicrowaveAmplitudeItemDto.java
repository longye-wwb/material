package com.crledu.auto.material.microw.data.dto;

import com.crledu.auto.web.vo.number.FloatParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波宽带振幅转换列表数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:32
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波宽带振幅转换列表")
public class MicrowaveAmplitudeItemDto {

    @ApiModelProperty("主键")
    private Long id;

    /**
     * 两端线宽
     */
    @ApiModelProperty("两端线宽")
    private Float widthLength;

    /**
     * 中间电容线长
     */
    @ApiModelProperty("中间电容线长")
    private Float length;

    /**
     * 中间电容线宽
     */
    @ApiModelProperty("中间电容线宽")
    private Float width;

    /**
     * 介质材料介电常数
     */
    @ApiModelProperty("介质材料介电常数")
    private Float constant;

    /**
     * 介质材料厚度
     */
    @ApiModelProperty("介质材料厚度")
    private Float thickness;

    /**
     * 介质材料x方向尺寸
     */
    @ApiModelProperty("介质材料x方向尺寸")
    private Float xpath;

    /**
     * 介质材料y方向材料
     */
    @ApiModelProperty("介质材料y方向材料")
    private Float ypath;

    /**
     * 电容缝隙宽度
     */
    @ApiModelProperty("电容缝隙宽度")
    private Float gap;

    /**
     * 数据来源
     */
    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    /**
     * 工作方式
     */
    @ApiModelProperty("工作方式")
    private Integer workingMode;

    @ApiModelProperty("入射光偏振态")
    private Integer amplitudeType;

    /**
     * 入射角
     */
    @ApiModelProperty("入射角")
    private Float lightAngle;

    /**
     * 导入历史主键
     */
    @ApiModelProperty("导入历史主键")
    private Long importId;

    @ApiModelProperty("相对带宽")
    private Float bandwidth;

    public MicrowaveAmplitudeItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWidthLength() {
        return widthLength;
    }

    public void setWidthLength(Float widthLength) {
        this.widthLength = widthLength;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getConstant() {
        return constant;
    }

    public void setConstant(Float constant) {
        this.constant = constant;
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Float getXpath() {
        return xpath;
    }

    public void setXpath(Float xpath) {
        this.xpath = xpath;
    }

    public Float getYpath() {
        return ypath;
    }

    public void setYpath(Float ypath) {
        this.ypath = ypath;
    }

    public Float getGap() {
        return gap;
    }

    public void setGap(Float gap) {
        this.gap = gap;
    }

    public Integer getDataFrom() {
        return dataFrom;
    }

    public void setDataFrom(Integer dataFrom) {
        this.dataFrom = dataFrom;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public Integer getAmplitudeType() {
        return amplitudeType;
    }

    public void setAmplitudeType(Integer amplitudeType) {
        this.amplitudeType = amplitudeType;
    }

    public Float getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Float bandwidth) {
        this.bandwidth = bandwidth;
    }
}
