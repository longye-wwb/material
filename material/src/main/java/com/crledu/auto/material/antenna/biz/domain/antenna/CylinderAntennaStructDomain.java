package com.crledu.auto.material.antenna.biz.domain.antenna;

import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;

/**
 ************************************************************
 * @Description: 圆柱纳米天线
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 16:15
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CylinderAntennaStructDomain extends AntennaStructDomain {

    public static final Integer CYLINDER_TYPE_VALUE = 1;

    private Float radius;
    private Float height;

    public CylinderAntennaStructDomain(String material, Float dielectricConstant, Float radius, Float height) {
        super(CYLINDER_TYPE_VALUE, material, dielectricConstant);
        this.radius = radius;
        this.height = height;
    }

    public Float getRadius() {
        return radius;
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public AntennaStructDataDto buildDataDomain() {
        AntennaStructDataDto dataDto = new AntennaStructDataDto();
        dataDto.setConstant(getDielectricConstant());
        dataDto.setMaterial(getMaterial());
        dataDto.setType(getType());
        dataDto.setHeight(height);
        dataDto.setRadius(radius);
        return dataDto;
    }
}
