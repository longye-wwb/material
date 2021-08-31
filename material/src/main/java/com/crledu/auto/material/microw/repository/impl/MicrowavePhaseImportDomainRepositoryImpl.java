package com.crledu.auto.material.microw.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microw.biz.domain.MicrowavePhaseImportDomain;
import com.crledu.auto.material.microw.biz.repository.BaseMicrowavePhaseImportDomainRepository;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowavePhaseDao;
import com.crledu.auto.material.microw.repository.dto.MicrowavePhaseEntityDataDto;
import com.crledu.auto.material.microw.repository.entity.MicrowavePhaseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 微波宽带相位调控业务对象数据仓库mysql实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 17:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class MicrowavePhaseImportDomainRepositoryImpl implements BaseMicrowavePhaseImportDomainRepository {

    @Resource
    private BaseMicrowavePhaseDao dao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public MicrowavePhaseImportDomain createWithData(Long id) {
        return null;
    }

    @Override
    public MicrowavePhaseImportDomain saveInData(MicrowavePhaseImportDomain domain) {
        MicrowavePhaseEntityDataDto dataDto = buildDataDto(domain);
        String dataFile = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            MicrowavePhaseEntity entity = new MicrowavePhaseEntity();
            BeanUtils.copyProperties(dataDto,entity);
            entity.setData(dataFile);
            dao.insert(entity);
            return createWithData(entity.getId());
        }else{
            return domain;
        }

    }

    @Override
    public MicrowavePhaseImportDomain updateToData(MicrowavePhaseImportDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    private MicrowavePhaseEntityDataDto buildDataDto(MicrowavePhaseImportDomain domain){
        MicrowavePhaseEntityDataDto dataDto = new MicrowavePhaseEntityDataDto();
        dataDto.setArmr(domain.getArmR());
        dataDto.setArmy(domain.getArmY());
        dataDto.setDataArr(domain.getData());
        dataDto.setLaylerx(domain.getLaylerx());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setLightType(domain.getLightType());
        dataDto.setPeriod(domain.getPeriod());
        dataDto.setPermittivity(domain.getPermittivity());
        dataDto.setRectx(domain.getRectX());
        dataDto.setRectx2(domain.getRectX2());
        dataDto.setSubh(domain.getSubH());
        dataDto.setRecty(domain.getArmY());
        dataDto.setThickness(domain.getThickness());
        dataDto.setWorkingMode(domain.getWorkingMode());
        dataDto.setImportId(domain.getImportId());
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setBandwidth(domain.getBandwidth());
        return dataDto;
    }
}
