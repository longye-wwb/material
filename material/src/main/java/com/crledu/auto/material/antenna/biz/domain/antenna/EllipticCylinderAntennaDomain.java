package com.crledu.auto.material.antenna.biz.domain.antenna;

import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;

/**
 ************************************************************
 * @Description: 椭圆柱天线业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 16:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class EllipticCylinderAntennaDomain extends AntennaStructDomain {

    public static final Integer ELLIPTIC_CYLINDER_TYPE_ID = 5;

    private Float longAxis;
    private Float minorAxis;
    private Float height;

    public EllipticCylinderAntennaDomain(String material, Float dielectricConstant, Float longAxis, Float minorAxis, Float height) {
        super(ELLIPTIC_CYLINDER_TYPE_ID, material, dielectricConstant);
        this.longAxis = longAxis;
        this.minorAxis = minorAxis;
        this.height = height;
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
