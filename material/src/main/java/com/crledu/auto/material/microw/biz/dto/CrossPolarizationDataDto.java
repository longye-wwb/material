package com.crledu.auto.material.microw.biz.dto;

/**
 ************************************************************
 * @Description: 交叉极化幅度数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 17:03
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CrossPolarizationDataDto {

    private Float wavelength;
    private Float range;

    public CrossPolarizationDataDto() {
    }

    public Float getWavelength() {
        return wavelength;
    }

    public void setWavelength(Float wavelength) {
        this.wavelength = wavelength;
    }

    public Float getRange() {
        return range;
    }

    public void setRange(Float range) {
        this.range = range;
    }
}
