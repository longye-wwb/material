package com.crledu.auto.material.antenna.biz.domain.base;

import com.crledu.auto.material.antenna.biz.dto.AntennaBaseStructDataDto;

/**
 ************************************************************
 * @Description: 天线基底结构业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 14:11
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AntennaBaseStructDomain {

    private Integer type;
    private String material;
    private Float dielectricConstant;

    public AntennaBaseStructDomain(Integer type, String material, Float dielectricConstant) {
        this.type = type;
        this.material = material;
        this.dielectricConstant = dielectricConstant;
    }

    public Integer getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public Float getDielectricConstant() {
        return dielectricConstant;
    }

    public abstract AntennaBaseStructDataDto buildDataDto();
}
