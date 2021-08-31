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
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkyVo {

    private Long id;

    @ApiModelProperty(value = "纳米天线结构类型")
    private String topType;

    @ApiModelProperty(value = "纳米天线材料")
    private Double topConstant;

    @ApiModelProperty(value = "基底结构类型")
    private String downType;

    @ApiModelProperty(value = "基底材料")
    private Double downConstant;

    @ApiModelProperty(value = "数据来源")
    private String source;

    @ApiModelProperty(value = "入射光源类型")
    private String lightType;

    @ApiModelProperty(value = "入射角")
    private Double lightAngle;

    @ApiModelProperty(value ="工作方式")
    private String workType;

    @ApiModelProperty(value = "起始波段")
    private Double start;

    @ApiModelProperty(value = "结束波段")
    private Double end;

    @ApiModelProperty(value = "相位分布")
    private Double amplitude;

    @ApiModelProperty(value = "振幅分布")
    private Double phase;

    @ApiModelProperty(value = "实部")
    private Double trueth;

    @ApiModelProperty(value = "虚部")
    private Double fake;

    private String file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopType() {
        return topType;
    }

    public void setTopType(String topType) {
        this.topType = topType;
    }

    public Double getTopConstant() {
        return topConstant;
    }

    public void setTopConstant(Double topConstant) {
        this.topConstant = topConstant;
    }

    public String getDownType() {
        return downType;
    }

    public void setDownType(String downType) {
        this.downType = downType;
    }

    public Double getDownConstant() {
        return downConstant;
    }

    public void setDownConstant(Double downConstant) {
        this.downConstant = downConstant;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLightType() {
        return lightType;
    }

    public void setLightType(String lightType) {
        this.lightType = lightType;
    }

    public Double getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Double lightAngle) {
        this.lightAngle = lightAngle;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getEnd() {
        return end;
    }

    public void setEnd(Double end) {
        this.end = end;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

    public Double getPhase() {
        return phase;
    }

    public void setPhase(Double phase) {
        this.phase = phase;
    }

    public Double getTrueth() {
        return trueth;
    }

    public void setTrueth(Double trueth) {
        this.trueth = trueth;
    }

    public Double getFake() {
        return fake;
    }

    public void setFake(Double fake) {
        this.fake = fake;
    }


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
