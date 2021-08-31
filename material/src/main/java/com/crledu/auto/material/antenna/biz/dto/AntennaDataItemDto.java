package com.crledu.auto.material.antenna.biz.dto;

import com.crledu.auto.material.photon.repository.util.DoubleUtil;

/**
 ************************************************************
 * @Description: 纳米天线模拟数据结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 17:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AntennaDataItemDto {

    private Float waveLength;
    private Float phase;
    private Float amplitude;

    public AntennaDataItemDto() {
    }

    public AntennaDataItemDto(Float waveLength, Float phase, Float amplitude) {
        this.waveLength = waveLength;
        this.amplitude = amplitude;
        this.phase = phase;
    }

    public Float getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Float waveLength) {
        this.waveLength = waveLength;
    }

    public Float getPhase() {
        return phase;
    }

    public void setPhase(Float phase) {
        this.phase = phase;
    }

    public Float getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Float amplitude) {
        this.amplitude = amplitude;
    }
}
