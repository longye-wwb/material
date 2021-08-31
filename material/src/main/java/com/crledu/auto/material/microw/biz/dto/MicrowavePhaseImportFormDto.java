package com.crledu.auto.material.microw.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;

/**
 ************************************************************
 * @Description: 微波宽带相位调控表单补充数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 16:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowavePhaseImportFormDto extends ImportItemFormData {

    /**
     * 金属厚度
     */
    private Float thickness;

    /**
     * 入射角
     */
    private Float lightAngle;

    private Integer lightType;

    /**
     * 工作方式
     */
    private Integer workingMode;

    public MicrowavePhaseImportFormDto() {
    }

    public Float getThickness() {
        return thickness;
    }

    public void setThickness(Float thickness) {
        this.thickness = thickness;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public void setLightAngle(Float lightAngle) {
        this.lightAngle = lightAngle;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public void setWorkingMode(Integer workingMode) {
        this.workingMode = workingMode;
    }

    public Integer getLightType() {
        return lightType;
    }

    public void setLightType(Integer lightType) {
        this.lightType = lightType;
    }
}
