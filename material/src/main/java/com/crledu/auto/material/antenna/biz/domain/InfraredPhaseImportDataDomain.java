package com.crledu.auto.material.antenna.biz.domain;

import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;

/**
 ************************************************************
 * @Description: 红外宽带位相调控业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 14:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class InfraredPhaseImportDataDomain extends AntennaImportDataDomain {
    @TableConstructor
    public InfraredPhaseImportDataDomain(/*@ColumnName("h1") Float baseHeight,*/ @ColumnName("p") Float baseSide,/* @ColumnName("r")Float radius,*/ @ColumnName("h2") Float height, @ColumnName("l")Float longAxis, @ColumnName("w")Float minorAxis,@ColumnName("eff") Float eff, AntennaImportFormdataDto formdataDto, Float[] wavelength, @DataName("real")String[] realArray, @DataName("empty")String[] emptyArray) {
        super(/*baseHeight,*/ baseSide, /*radius,*/ height, longAxis, minorAxis,eff, formdataDto, wavelength, realArray, emptyArray);
    }
}
