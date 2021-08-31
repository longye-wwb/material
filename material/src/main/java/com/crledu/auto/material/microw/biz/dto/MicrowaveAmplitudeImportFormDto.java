package com.crledu.auto.material.microw.biz.dto;

import com.crledu.auto.material.base.dto.ImportItemFormData;

/**
 ************************************************************
 * @Description: 微波宽带振幅转换-表单数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 10:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class MicrowaveAmplitudeImportFormDto extends ImportItemFormData {

    private Float lightAngle;
    private Integer workingMode;

    private Integer amplitudeType;

    public MicrowaveAmplitudeImportFormDto() {
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

    public Integer getAmplitudeType() {
        return amplitudeType;
    }

    public void setAmplitudeType(Integer amplitudeType) {
        this.amplitudeType = amplitudeType;
    }
}
