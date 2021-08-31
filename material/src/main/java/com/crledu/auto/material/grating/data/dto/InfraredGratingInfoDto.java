package com.crledu.auto.material.grating.data.dto;

import com.crledu.auto.material.base.dto.lineDataItemDto;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 ************************************************************
 * @Description: 红外窄带传感详情数据格式
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/4 18:04
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("红外窄带传感详情")
public class InfraredGratingInfoDto extends InfraredGratingItemDto {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
