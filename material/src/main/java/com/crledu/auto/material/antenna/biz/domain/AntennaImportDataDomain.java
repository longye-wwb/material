package com.crledu.auto.material.antenna.biz.domain;

import com.crledu.auto.material.antenna.biz.domain.antenna.*;
import com.crledu.auto.material.antenna.biz.domain.base.AntennaBaseStructDomain;
import com.crledu.auto.material.antenna.biz.domain.base.HexagonAntennaBaseStructDomain;
import com.crledu.auto.material.antenna.biz.domain.base.SquareAntennaBaseStructDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaDataItemDto;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.base.domain.AbstructImportDomain;
import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.base.service.annotation.DataName;
import com.crledu.auto.material.base.service.annotation.TableConstructor;
import com.crledu.auto.web.exception.RestRuntimeException;

import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 纳米天线业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 16:43
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AntennaImportDataDomain extends AbstructImportDomain{

    private AntennaBaseStructDomain baseDomain;
    private AntennaStructDomain antenna;

    private Integer lightType;
    private Integer workingMode;
    private Float lightAngle;
    private List<AntennaDataItemDto> data;
    private Float eff;

    @TableConstructor
    public AntennaImportDataDomain(  Float baseSide, Float height, Float longAxis, Float minorAxis,Float eff, AntennaImportFormdataDto formdataDto, Float[] wavelength, String[] realArray,String[] emptyArray) {
        super(formdataDto);
        Float baseHeight = 0f;
        Float radius = 0f;
        lightType = formdataDto.getLightType();
        workingMode = formdataDto.getWorkingMode();
        lightAngle = formdataDto.getLightAngle();
        this.eff = eff;
        //构造结构参数
        if(formdataDto.getBaseType() == SquareAntennaBaseStructDomain.BASE_TYPE_ID.intValue()){
            baseDomain = new SquareAntennaBaseStructDomain(formdataDto.getBaseMaterial(),formdataDto.getBaseConstant(),baseHeight,baseSide);
        }else if(formdataDto.getBaseType() == HexagonAntennaBaseStructDomain.BASE_TYPE_ID.intValue()){
            baseDomain = new HexagonAntennaBaseStructDomain(formdataDto.getBaseMaterial(),formdataDto.getBaseConstant(),baseHeight,baseSide);
        }else {
            throw  new RestRuntimeException("系统不存在当前天线结构类型。请检查参数。","1400000101");
        }

        if(formdataDto.getType() == CylinderAntennaStructDomain.CYLINDER_TYPE_VALUE.intValue()){
            antenna = new CylinderAntennaStructDomain(formdataDto.getMaterial(),formdataDto.getConstant(),radius,height);
        }else if(formdataDto.getType() == CircularHoleAntennaDomain.CIRCULAR_HOLE_TYPE_VALUE.intValue()){
            antenna = new CircularHoleAntennaDomain(formdataDto.getMaterial(),formdataDto.getConstant(),radius,height);
        }else if(formdataDto.getType() == SquareColumnAntennaDomain.SQUARE_COLUMN_TYPE_VALUE.intValue()){
            antenna = new SquareColumnAntennaDomain(formdataDto.getMaterial(),formdataDto.getConstant(),longAxis,minorAxis,height);
        }else if(formdataDto.getType() == SquareHoleAntennaDomain.SQUARE_HOLE_ANTENNA_TYPE.intValue()) {
            antenna = new SquareHoleAntennaDomain(formdataDto.getMaterial(), formdataDto.getConstant(), longAxis, minorAxis, height);
        }else if(formdataDto.getType() == EllipticCylinderAntennaDomain.ELLIPTIC_CYLINDER_TYPE_ID.intValue()){
            antenna = new EllipticCylinderAntennaDomain(formdataDto.getMaterial(),formdataDto.getConstant(),longAxis,minorAxis,height);
        }else{
            throw  new RestRuntimeException("1400000101","系统不存在当前天线结构类型。请检查参数。");
        }

        //分析实部与虚部数据
        data = new ArrayList<>();
        for(int i = 0;i < wavelength.length;i++){
            AntennaDataItemDto itemDto = new AntennaDataItemDto(wavelength[i],Float.parseFloat(realArray[i]),Float.parseFloat(emptyArray[i]));
            data.add(itemDto);
        }
    }

    public AntennaBaseStructDomain getBaseDomain() {
        return baseDomain;
    }

    public AntennaStructDomain getAntenna() {
        return antenna;
    }

    public Integer getLightType() {
        return lightType;
    }

    public Integer getWorkingMode() {
        return workingMode;
    }

    public Float getLightAngle() {
        return lightAngle;
    }

    public List<AntennaDataItemDto> getData() {
        return data;
    }

    public Float getEff() {
        return eff;
    }
}
