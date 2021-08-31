package com.crledu.auto.material.photon.repository.dto;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/11/30
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class NanoAntennaLayerDto {


    private Double fake;
    //实部数据
    private Double truth;
    //相位
    private Double phase;
    //振幅
    private Double amplitude;

    //频率
    private Double frequncy;

    private Double waveLength;

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

    public Double getFrequncy() {
        return frequncy;
    }

    public void setFrequncy(Double frequncy) {
        this.frequncy = frequncy;
    }

    public Double getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Double waveLength) {
        this.waveLength = waveLength;
    }
}
