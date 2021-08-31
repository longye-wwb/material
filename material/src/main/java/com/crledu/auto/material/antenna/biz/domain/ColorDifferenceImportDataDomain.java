package com.crledu.auto.material.antenna.biz.domain;

import com.crledu.auto.material.antenna.biz.dto.AntennaDataItemDto;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.web.vo.number.FloatParamVo;

import java.util.List;

/**
 ************************************************************
 * @Description: 消色差器件数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 14:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ColorDifferenceImportDataDomain extends AntennaImportDataDomain{

    private Float delayed;

    private Float waveStart;

    private Float waveEnd;

    @TableConstructor
    public ColorDifferenceImportDataDomain(/*@ColumnName("h1") Float baseHeight,*/ @ColumnName("p") Float baseSide, /*@ColumnName("r")Float radius,*/ @ColumnName("h2") Float height, @ColumnName("l")Float longAxis, @ColumnName("w")Float minorAxis, @ColumnName("eff") Float eff, AntennaImportFormdataDto formdataDto, Float[] wavelength, @DataName("real")String[] realArray, @DataName("empty")String[] emptyArray) {
        super(baseSide, height, longAxis, minorAxis, eff, formdataDto, wavelength, realArray, emptyArray);
        //附加计算群延时
        //获取其实波段
        List<AntennaDataItemDto> listData = getData();
        if(ObjectUtils.isNotNull(listData)){
            waveStart = listData.get(0).getWaveLength();
            waveEnd = listData.get(listData.size()-1).getWaveLength();
            Float amStep = listData.get(0).getAmplitude() - listData.get(listData.size()-1).getAmplitude();
            delayed = amStep / (waveStart - waveEnd);
        }
    }

    public Float getDelayed() {
        return delayed;
    }

    public Float getWaveStart() {
        return waveStart;
    }

    public Float getWaveEnd() {
        return waveEnd;
    }
}
