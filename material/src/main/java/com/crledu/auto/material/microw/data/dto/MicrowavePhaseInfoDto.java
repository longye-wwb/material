package com.crledu.auto.material.microw.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波相位调控详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("微波相位调控详情")
public class MicrowavePhaseInfoDto extends MicrowavePhaseItemDto{

    @ApiModelProperty("详细数据")
    private String dataArr;

    public MicrowavePhaseInfoDto() {
    }

    public String getDataArr() {
        return dataArr;
    }

    public void setDataArr(String dataArr) {
        this.dataArr = dataArr;
    }
}
