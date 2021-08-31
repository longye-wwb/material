package com.crledu.auto.material.antenna.biz.domain.antenna;

import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;

/**
 ************************************************************
 * @Description: 方柱天线业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 16:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class SquareColumnAntennaDomain extends AntennaStructDomain {

    public static final Integer SQUARE_COLUMN_TYPE_VALUE = 3;
    private Float longAxis;
    private Float minorAxis;
    private Float height;

    public SquareColumnAntennaDomain(String material, Float dielectricConstant, Float longAxis, Float minorAxis, Float height) {
        super(SQUARE_COLUMN_TYPE_VALUE, material, dielectricConstant);
        this.longAxis = longAxis;
        this.minorAxis = minorAxis;
        this.height = height;
    }

    public Float getLongAxis() {
        return longAxis;
    }

    public Float getMinorAxis() {
        return minorAxis;
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
        dataDto.setLongAxis(longAxis);
        dataDto.setMinorAxis(minorAxis);
        return dataDto;
    }
}
