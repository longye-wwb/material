package com.crledu.auto.material.photon.repository.dto;

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
public class PhotonSkyNewDto {

    //相位分布
    private Double phase;
    //振幅分布
    private Double amplitude;
    private Double fake;
    private Double truth;

    //波长
    private Double waveLength;
    //频率
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

    @Override
    public String toString() {
        return "PhotonSkyNewDto{" +
                "phase=" + phase +
                ", amplitude=" + amplitude +
                ", fake=" + fake +
                ", truth=" + truth +
                ", waveLength=" + waveLength +
                '}';
    }
}
