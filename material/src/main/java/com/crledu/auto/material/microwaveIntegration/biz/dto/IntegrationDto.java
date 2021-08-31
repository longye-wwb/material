package com.crledu.auto.material.microwaveIntegration.biz.dto;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class IntegrationDto {

    //波长
    private Float waveLength;
    //宽吸收率
    private Float broadbandData;
    //窄吸收
    private Float narrowbandData;

    public Float getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Float waveLength) {
        this.waveLength = waveLength;
    }

    public Float getBroadbandData() {
        return broadbandData;
    }

    public void setBroadbandData(Float broadbandData) {
        this.broadbandData = broadbandData;
    }

    public Float getNarrowbandData() {
        return narrowbandData;
    }

    public void setNarrowbandData(Float narrowbandData) {
        this.narrowbandData = narrowbandData;
    }

    public IntegrationDto(Float waveLength, Float broadbandData, Float narrowbandData) {
        this.waveLength = waveLength;
        this.broadbandData = broadbandData;
        this.narrowbandData = narrowbandData;
    }
}
