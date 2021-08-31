package com.crledu.auto.material.cooling.biz.dto;

/**
 ************************************************************
 * @Description: 辐射制冷材料详情
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 17:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CoolingMaterialInfoDto extends CoolingMaterialItemDto{
    private String abs;

    public CoolingMaterialInfoDto() {
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }
}
