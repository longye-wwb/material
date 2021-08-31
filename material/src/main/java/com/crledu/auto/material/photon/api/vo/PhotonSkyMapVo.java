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
 * @Date: 2020/9/16
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkyMapVo {

    //相位分布
    @ApiModelProperty(value = "相位分布")
    private Double phase;
    //振幅分布
    @ApiModelProperty(value = "振幅分布")
    private Double amplitude;
    @ApiModelProperty(value = "虚部")
    private Double fake;
    @ApiModelProperty(value = "实部")
    private Double truth;
    //开始波段
    @ApiModelProperty(value = "开始波段")
    private Double start;
    //结束波段
    @ApiModelProperty(value = "结束波段")
    private Double end;
    //波长
    @ApiModelProperty(value = "波长")
    private Double waveLength;
    //频率
    @ApiModelProperty(value = "频率")
    private Double frequency;


    public Double getPhase() {
        return phase;
    }

    public void setPhase(Double phase) {
        this.phase = phase;
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = amplitude;
    }

    public Double getFake() {
        return fake;
    }

    public void setFake(Double fake) {
        this.fake = fake;
    }

    public Double getTruth() {
        return truth;
    }

    public void setTruth(Double truth) {
        this.truth = truth;
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

    public Double getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Double waveLength) {
        this.waveLength = waveLength;
    }

    public Double getFrequency() {
        return frequency;
    }

    public void setFrequency(Double frequency) {
        this.frequency = frequency;
    }
}
