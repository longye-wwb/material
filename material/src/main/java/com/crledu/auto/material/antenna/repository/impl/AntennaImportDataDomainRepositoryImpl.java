package com.crledu.auto.material.antenna.repository.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.ColorDifferenceImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaBaseStructDataDto;
import com.crledu.auto.material.antenna.biz.dto.AntennaStructDataDto;
import com.crledu.auto.material.antenna.repository.BaseAntennaImportDataDomainRepository;
import com.crledu.auto.material.antenna.repository.dto.AntennaEntityDataDto;
import com.crledu.auto.material.antenna.repository.dto.ColorDifferenceDataDto;
import com.crledu.auto.material.antenna.repository.entity.AbstractAntennaEntity;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import org.springframework.beans.BeanUtils;

/**
 ************************************************************
 * @Description: 天线导入数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 9:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract  class AntennaImportDataDomainRepositoryImpl implements BaseAntennaImportDataDomainRepository
{
    private BaseMapper dao;

    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public AntennaImportDataDomain save(AntennaImportDataDomain domian) {
        AntennaEntityDataDto dataDto = getNewEntityDataDto();
        buileEntityData(domian,dataDto);
        String filePath = bigdataRepositoryService.saveData(dataDto,domian.getImportId());
        if(domian.getSaveData()){
            AbstractAntennaEntity entity = getNewEntity();
            buileEntity(entity,dataDto);
            entity.setData(filePath);
            dao.insert(entity);
            return get(entity.getId());
        }else{
            return domian;
        }

    }

    protected abstract AntennaEntityDataDto getNewEntityDataDto();

    private void buileEntityData(AntennaImportDataDomain domian , AntennaEntityDataDto dto){
        AntennaStructDataDto antennaStructDataDto = domian.getAntenna().buildDataDomain();
        AntennaBaseStructDataDto baseStructDataDto = domian.getBaseDomain().buildDataDto();
        dto.setBaseConstant(baseStructDataDto.getConstant());
        dto.setBaseMaterial(baseStructDataDto.getMaterial());
        dto.setBaseSide(baseStructDataDto.getSide());
        dto.setBaseThickness(baseStructDataDto.getThickness());
        dto.setConstant(antennaStructDataDto.getConstant());
        dto.setDataArray(domian.getData());
        dto.setDataFrom(domian.getDataFrom());
        dto.setHeight(antennaStructDataDto.getHeight());
        dto.setImportId(domian.getImportId());
        dto.setLightAngle(domian.getLightAngle());
        dto.setLightType(domian.getLightType());
        dto.setLongAxis(antennaStructDataDto.getLongAxis());
        dto.setMaterial(antennaStructDataDto.getMaterial());
        dto.setMinorAxis(antennaStructDataDto.getMinorAxis());
        dto.setRadius(antennaStructDataDto.getRadius());
        dto.setType(antennaStructDataDto.getType());
        dto.setWorkingMode(domian.getWorkingMode());
        dto.setBaseType(baseStructDataDto.getType());
        dto.setEff(domian.getEff());
        if(dto instanceof ColorDifferenceDataDto){
            ColorDifferenceDataDto colorDifferenceDataDto = (ColorDifferenceDataDto)dto;
            ColorDifferenceImportDataDomain colorDifferenceImportDataDomain = (ColorDifferenceImportDataDomain) domian;
            colorDifferenceDataDto.setDelayed(colorDifferenceImportDataDomain.getDelayed());
            colorDifferenceDataDto.setWaveStart(colorDifferenceImportDataDomain.getWaveStart());
            colorDifferenceDataDto.setWaveEnd(colorDifferenceImportDataDomain.getWaveEnd());
        }
    }

    private void buileEntity(AbstractAntennaEntity entity , AntennaEntityDataDto dto){
        BeanUtils.copyProperties(dto,entity);
    }

    protected abstract AbstractAntennaEntity getNewEntity();

    protected void setDao(BaseMapper dao) {
        this.dao = dao;
    }

    protected void setBigdataRepositoryService(BaseBigdataRepositoryService bigdataRepositoryService) {
        this.bigdataRepositoryService = bigdataRepositoryService;
    }

}
