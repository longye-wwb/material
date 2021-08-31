package com.crledu.auto.material.antenna.biz.domain.base;

import com.crledu.auto.material.antenna.biz.dto.AntennaBaseStructDataDto;

/**
 ************************************************************
 * @Description: 正方形天线基底
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 14:24
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SquareAntennaBaseStructDomain extends AntennaBaseStructDomain {

    public static final Integer BASE_TYPE_ID = 1;

    private Float thickness;
    private Float side;

    public SquareAntennaBaseStructDomain(String material, Float dielectricConstant, Float thickness, Float side) {
        super(BASE_TYPE_ID, material, dielectricConstant);
        this.thickness = thickness;
        this.side = side;
    }

    public Float getThickness() {
        return thickness;
    }

    public Float getSide() {
        return side;
    }

    @Override
    public AntennaBaseStructDataDto buildDataDto() {
        AntennaBaseStructDataDto dataDto = new AntennaBaseStructDataDto();
        dataDto.setConstant(getDielectricConstant());
        dataDto.setMaterial(getMaterial());
        dataDto.setSide(side);
        dataDto.setThickness(thickness);
        dataDto.setType(getType());
        return dataDto;
    }
}
