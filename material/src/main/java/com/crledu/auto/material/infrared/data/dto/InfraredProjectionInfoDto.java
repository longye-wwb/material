package com.crledu.auto.material.infrared.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 微波红外一体化
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 9:19
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("红外微波透射一体化数据项详情")
public class InfraredProjectionInfoDto extends InfraredProjectionItemDto {

    @ApiModelProperty("透射率数据")
    private String projection;

    public InfraredProjectionInfoDto() {
        super();
    }

    public String getProjection() {
        return projection;
    }

    public void setProjection(String projection) {
        this.projection = projection;
    }
}
