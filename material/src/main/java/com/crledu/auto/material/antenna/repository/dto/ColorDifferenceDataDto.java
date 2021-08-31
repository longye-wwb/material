package com.crledu.auto.material.antenna.repository.dto;

/**
 ************************************************************
 * @Description: 消色差结构数据存储结构
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 15:21
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ColorDifferenceDataDto extends AntennaEntityDataDto {

    private Float delayed;

    private Float waveStart;

    private Float waveEnd;

    public ColorDifferenceDataDto() {
        super();
    }

    public Float getDelayed() {
        return delayed;
    }

    public void setDelayed(Float delayed) {
        this.delayed = delayed;
    }

    public Float getWaveStart() {
        return waveStart;
    }

    public void setWaveStart(Float waveStart) {
        this.waveStart = waveStart;
    }

    public Float getWaveEnd() {
        return waveEnd;
    }

    public void setWaveEnd(Float waveEnd) {
        this.waveEnd = waveEnd;
    }
}
