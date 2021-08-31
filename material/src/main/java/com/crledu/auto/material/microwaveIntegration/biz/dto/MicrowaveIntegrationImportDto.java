package com.crledu.auto.material.microwaveIntegration.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;

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
public class MicrowaveIntegrationImportDto extends ImportItemFormData {

    private Integer lightType;
    //入射角度
    private Float lightAngle;
    //工作方式
    private Integer workType;

    //介电常数
    private Float dielectric;

    /**
     * 方形环周期
     */
    private Float p;

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    public Float getDielectric() {
        return dielectric;
    }

    public void setDielectric(Float dielectric) {
        this.dielectric = dielectric;
    }

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
    }
}
