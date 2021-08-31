package com.crledu.auto.material.microwave.biz.dto;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public class AbsorptionRateDto {
    //波长
    private Float waveLength;
    //吸收率
    private Float absorptionRate;

    public AbsorptionRateDto(Float waveLength, Float valueOf) {
        this.waveLength=waveLength;
        this.absorptionRate=valueOf;
    }

    public Float getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Float waveLength) {
        this.waveLength = waveLength;
    }

    public Float getAbsorptionRate() {
        return absorptionRate;
    }

    public void setAbsorptionRate(Float absorptionRate) {
        this.absorptionRate = absorptionRate;
    }
}
