package com.crledu.auto.material.infrared.biz.dto;

/**
 ************************************************************
 * @Description: 投射数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:46
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ProjectionDataItemDto {

    /**
     * 波长
     */
    private Float wavelength;

    /**
     * 透射率
     */
    private Float projection;

    public ProjectionDataItemDto() {
    }

    public Float getWavelength() {
        return wavelength;
    }

    public void setWavelength(Float wavelength) {
        this.wavelength = wavelength;
    }

    public Float getProjection() {
        return projection;
    }

    public void setProjection(Float projection) {
        this.projection = projection;
    }
}
