package com.crledu.auto.material.antenna.biz.domain.antenna;

import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;

/**
 ************************************************************
 * @Description: 圆孔天线业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 16:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CircularHoleAntennaDomain extends AntennaStructDomain {

    public static final Integer CIRCULAR_HOLE_TYPE_VALUE = 2;

    private Float radius;
    private Float height;

    public CircularHoleAntennaDomain(String material, Float dielectricConstant, Float radius, Float height) {
        super(CIRCULAR_HOLE_TYPE_VALUE, material, dielectricConstant);
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
