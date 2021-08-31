package com.crledu.auto.material.antenna.biz.domain.antenna;

import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;

/**
 ************************************************************
 * @Description: 纳米天线结构业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 14:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AntennaStructDomain {

    private  Integer type;
    private String material;
    private Float dielectricConstant;

    public AntennaStructDomain(Integer type, String material, Float dielectricConstant) {
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

    public abstract AntennaStructDataDto buildDataDomain();


}
