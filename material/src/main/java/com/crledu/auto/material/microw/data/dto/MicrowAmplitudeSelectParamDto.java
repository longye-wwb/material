package com.crledu.auto.material.microw.data.dto;

import com.crledu.auto.web.view.PageParamVO;
import com.crledu.auto.web.vo.number.FloatParamVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波宽带振幅转换查询参数
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:22
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波宽带振幅转换查询参数")
public class MicrowAmplitudeSelectParamDto extends PageParamVO {

    @ApiModelProperty("两端线宽")
    private FloatParamVo width;

    @ApiModelProperty("中间电容线长")
    private FloatParamVo lineLength;

    @ApiModelProperty("中间电容线宽")
    private FloatParamVo lineWidth;

    @ApiModelProperty("介质材料介电常数")
    private FloatParamVo constant;

    @ApiModelProperty("介质材料厚度")
    private FloatParamVo thickness;

    @ApiModelProperty("介质材料x方向尺寸")
    private FloatParamVo xpath;

    @ApiModelProperty("介质材料y方向尺寸")
    private FloatParamVo ypath;

    @ApiModelProperty("电容缝隙宽度")
    private FloatParamVo gap;

    @ApiModelProperty("数据来源")
    private Integer dataFrom;

    @ApiModelProperty("工作方式")
    private Integer workingMode;

    @ApiModelProperty("入射光偏振态")
    private Integer amplitudeType;

    @ApiModelProperty("入射角")
    private FloatParamVo lightAngle;

    @ApiModelProperty("相对带宽")
    private FloatParamVo bandwidth;

    public MicrowAmplitudeSelectParamDto() {
    }

    public FloatParamVo getWidth() {
        return width;
    }

    public void setWidth(FloatParamVo width) {
        this.width = width;
    }

    public FloatParamVo getLineLength() {
        return lineLength;
    }

    public void setLineLength(FloatParamVo lineLength) {
        this.lineLength = lineLength;
    }

    public FloatParamVo getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(FloatParamVo lineWidth) {
        this.lineWidth = lineWidth;
    }

    public FloatParamVo getConstant() {
        return constant;
    }

    public void setConstant(FloatParamVo constant) {
        this.constant = constant;
    }

    public FloatParamVo getThickness() {
        return thickness;
    }

    public void setThickness(FloatParamVo thickness) {
        this.thickness = thickness;
    }

    public FloatParamVo getXpath() {
        return xpath;
    }

    public void setXpath(FloatParamVo xpath) {
        this.xpath = xpath;
    }

    public FloatParamVo getYpath() {
        return ypath;
    }

    public void setYpath(FloatParamVo ypath) {
        this.ypath = ypath;
    }

    public FloatParamVo getGap() {
        return gap;
    }

    public void setGap(FloatParamVo gap) {
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

    public FloatParamVo getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(FloatParamVo lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getAmplitudeType() {
        return amplitudeType;
    }

    public void setAmplitudeType(Integer amplitudeType) {
        this.amplitudeType = amplitudeType;
    }

    public FloatParamVo getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(FloatParamVo bandwidth) {
        this.bandwidth = bandwidth;
    }
}
