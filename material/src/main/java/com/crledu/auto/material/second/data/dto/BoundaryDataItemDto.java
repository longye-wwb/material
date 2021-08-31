package com.crledu.auto.material.second.data.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 ************************************************************
 * @Description: 边界优化超透镜列表数据格式
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 17:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("边界优化超透镜列表数据")
public class BoundaryDataItemDto {

    @ApiModelProperty("偏振类型：1、x偏振；2、y偏振")
    private Integer type;
}
