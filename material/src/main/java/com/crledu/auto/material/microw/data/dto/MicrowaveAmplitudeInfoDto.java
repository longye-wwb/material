package com.crledu.auto.material.microw.data.dto;

import io.swagger.annotations.ApiModel;

/**
 ************************************************************
 * @Description: 微波偏振转换详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波偏振转换详情")
public class MicrowaveAmplitudeInfoDto extends MicrowaveAmplitudeItemDto {

    private String dataJson;

    public MicrowaveAmplitudeInfoDto() {
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }
}
