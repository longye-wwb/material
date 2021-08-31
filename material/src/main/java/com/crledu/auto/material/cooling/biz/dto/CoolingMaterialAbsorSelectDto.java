package com.crledu.auto.material.cooling.biz.dto;

import io.swagger.annotations.ApiModel;

/**
 ************************************************************
 * @Description: 辐射制冷材料吸收率筛选条件
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 17:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@ApiModel("辐射制冷材料详情过滤")
public class CoolingMaterialAbsorSelectDto {

    private Long id;

    public CoolingMaterialAbsorSelectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
