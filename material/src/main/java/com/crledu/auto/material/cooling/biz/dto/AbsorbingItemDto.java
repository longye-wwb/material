package com.crledu.auto.material.cooling.biz.dto;

/**
 ************************************************************
 * @Description: 吸收率数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 11:23
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbsorbingItemDto {

    private Float waveLength;
    private Float absorbing;

    public AbsorbingItemDto() {
    }

    public Float getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Float waveLength) {
        this.waveLength = waveLength;
    }

    public Float getAbsorbing() {
        return absorbing;
    }

    public void setAbsorbing(Float absorbing) {
        this.absorbing = absorbing;
    }
}
