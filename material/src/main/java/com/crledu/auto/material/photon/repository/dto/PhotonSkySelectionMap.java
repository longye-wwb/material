package com.crledu.auto.material.photon.repository.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/17
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class PhotonSkySelectionMap {

    @ApiModelProperty(value = "结构参数id")
    private Long id;

    @ApiModelProperty(value = "起始波长",required = true)
    private Double startWave;

    @ApiModelProperty(value = "结束波长",required = true)
    private Double endWave;

    @ApiModelProperty(value = "起始相位")
    private Double startPhase;

    @ApiModelProperty(value = "结束相位")
    private Double endPhase;

    @ApiModelProperty(value = "起始振幅")
    private Double startAmplitude;
    @ApiModelProperty(value = "结束振幅")
    private Double endAmplitude;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getStartWave() {
        return startWave;
    }

    public void setStartWave(Double startWave) {
        this.startWave = startWave;
    }

    public Double getEndWave() {
        return endWave;
    }

    public void setEndWave(Double endWave) {
        this.endWave = endWave;
    }

    public Double getStartPhase() {
        return startPhase;
    }

    public void setStartPhase(Double startPhase) {
        this.startPhase = startPhase;
    }

    public Double getEndPhase() {
        return endPhase;
    }

    public void setEndPhase(Double endPhase) {
        this.endPhase = endPhase;
    }

    public Double getStartAmplitude() {
        return startAmplitude;
    }

    public void setStartAmplitude(Double startAmplitude) {
        this.startAmplitude = startAmplitude;
    }

    public Double getEndAmplitude() {
        return endAmplitude;
    }

    public void setEndAmplitude(Double endAmplitude) {
        this.endAmplitude = endAmplitude;
    }
}
