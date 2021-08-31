package com.crledu.auto.material.antenna.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 纳米天线相似材料详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 16:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("纳米天线相似材料详情")
public class AntennaMaterialInfoDto extends AntennaMaterialItemDto {

    @ApiModelProperty("详细数据")
    private String dataStr;

    public AntennaMaterialInfoDto() {
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }
}
