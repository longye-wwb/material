package com.crledu.auto.material.microw.biz.dto;

/**
 ************************************************************
 * @Description: 微波宽带偏振转换
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 10:24
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class PhaseDifferenceDataDto {

    /**
     * 波长
     */
    private Float waveLength;

    /**
     * x轴相位
     */
    private Float phaseX;

    /**
     * y轴相位
     */
    private Float phaseY;

    /**
     * x-y相位差
     */
    private Float difference;

    public PhaseDifferenceDataDto() {
    }

    public PhaseDifferenceDataDto(Float waveLength, Float phaseX, Float phaseY) {
        this.waveLength = waveLength;
        this.phaseX = phaseX;
        this.phaseY = phaseY;
        this.difference = computeDifference();
    }

    private Float computeDifference(){
        return this.phaseX - this.phaseY;
    }

    public Float getWaveLength() {
        return waveLength;
    }

    public void setWaveLength(Float waveLength) {
        this.waveLength = waveLength;
    }

    public Float getPhaseX() {
        return phaseX;
    }

    public void setPhaseX(Float phaseX) {
        this.phaseX = phaseX;
    }

    public Float getPhaseY() {
        return phaseY;
    }

    public void setPhaseY(Float phaseY) {
        this.phaseY = phaseY;
    }

    public Float getDifference() {
        return difference;
    }

    public void setDifference(Float difference) {
        this.difference = difference;
    }
}
