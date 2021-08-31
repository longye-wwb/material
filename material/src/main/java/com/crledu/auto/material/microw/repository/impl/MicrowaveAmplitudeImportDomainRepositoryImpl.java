package com.crledu.auto.material.microw.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microw.biz.domain.MicrowaveAmplitudeImportDomain;
import com.crledu.auto.material.microw.biz.repository.BaseMicrowaveAmplitudeImportDomainRepository;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowaveAmplitudeDao;
import com.crledu.auto.material.microw.repository.dto.MicrowaveAmplitudeEntityDataDto;
import com.crledu.auto.material.microw.repository.entity.MicrowaveAmplitudeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 微波宽带偏振转换业务对象数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 14:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class MicrowaveAmplitudeImportDomainRepositoryImpl implements BaseMicrowaveAmplitudeImportDomainRepository {

    @Resource
    private BaseMicrowaveAmplitudeDao amplitudeDao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;


    @Override
    public MicrowaveAmplitudeImportDomain createWithData(Long id) {
        return null;
    }

    @Override
    public MicrowaveAmplitudeImportDomain saveInData(MicrowaveAmplitudeImportDomain domain) {
        MicrowaveAmplitudeEntityDataDto dataDto = buildEntityData(domain);
        String dataFile = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            MicrowaveAmplitudeEntity entity = new MicrowaveAmplitudeEntity();
            BeanUtils.copyProperties(dataDto,entity);
            entity.setData(dataFile);
            amplitudeDao.insert(entity);
            return createWithData(entity.getId());
        }else{
            return domain;
        }
    }

    @Override
    public MicrowaveAmplitudeImportDomain updateToData(MicrowaveAmplitudeImportDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    private MicrowaveAmplitudeEntityDataDto buildEntityData(MicrowaveAmplitudeImportDomain importDomain){
        MicrowaveAmplitudeEntityDataDto dataDto = new MicrowaveAmplitudeEntityDataDto();
        dataDto.setConstant(importDomain.getConstant());
        dataDto.setDataArr(importDomain.getData());
        dataDto.setDataFrom(importDomain.getDataFrom());
        dataDto.setGap(importDomain.getGapWidth());
        dataDto.setImportId(importDomain.getImportId());
        dataDto.setLength(importDomain.getLineLength());
        dataDto.setLightAngle(importDomain.getLightAngle());
        dataDto.setThickness(importDomain.getMediumThickness());
        dataDto.setWidth(importDomain.getLineWidth());
        dataDto.setWidthLength(importDomain.getWidth());
        dataDto.setWorkingMode(importDomain.getWorkingMode());
        dataDto.setAmplitudeType(importDomain.getAmplitudeType());
        dataDto.setXpath(importDomain.getxPath());
        dataDto.setYpath(importDomain.getyPath());
        dataDto.setBandwidth(importDomain.getBandwidth());
        return dataDto;
    }
}
