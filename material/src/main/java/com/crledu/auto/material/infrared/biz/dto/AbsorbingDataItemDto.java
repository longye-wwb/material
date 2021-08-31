package com.crledu.auto.material.infrared.biz.dto;

/**
 ************************************************************
 * @Description: 吸收率数据单项
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbsorbingDataItemDto {

    private Float wavelength;
    private Float absorbing;

    public AbsorbingDataItemDto() {
    }

    public Float getWavelength() {
        return wavelength;
    }

    public void setWavelength(Float wavelength) {
        this.wavelength = wavelength;
    }

    public Float getAbsorbing() {
        return absorbing;
    }

    public void setAbsorbing(Float absorbing) {
        this.absorbing = absorbing;
    }
}
