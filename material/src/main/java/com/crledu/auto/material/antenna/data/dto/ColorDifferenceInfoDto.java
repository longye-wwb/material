package com.crledu.auto.material.antenna.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 消色差数据详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:12
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("消色差结构详情")
public class ColorDifferenceInfoDto extends ColorDifferenceItemDto{

    @ApiModelProperty("详细数据")
    private String dataStr;

    public ColorDifferenceInfoDto() {
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }
}
