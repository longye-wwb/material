package com.crledu.auto.material.second.repository.impl;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.second.biz.domain.DiffractionDomian;
import com.crledu.auto.material.second.biz.repository.BaseDiffractionRepository;
import com.crledu.auto.material.second.repository.dao.BaseDiffractionMapper;
import com.crledu.auto.material.second.repository.dto.DiffractionDataDto;
import com.crledu.auto.material.second.repository.entity.DiffractionEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 衍射组件数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:10
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class DiffractionRepositoryImpl implements BaseDiffractionRepository {

    @Resource
    private BaseDiffractionMapper mapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveInData(DiffractionDomian domain) {
        DiffractionDataDto dataDto = new DiffractionDataDto();
        dataDto.setAngle(domain.getAngle());
        dataDto.setBaseRefractive(domain.getBaseRefractive());
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setDiffraction(domain.getDiffraction());
        dataDto.setImportId(domain.getImportId());
        dataDto.setInLine(domain.getInLine());
        dataDto.setOrder(domain.getOrder());
        dataDto.setPeriod(domain.getPeriod());
        dataDto.setPicture(domain.getPicture());
        dataDto.setRefractive(domain.getRefractive());
        String dataFile = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            DiffractionEntity entity = new DiffractionEntity();
            entity.setAngle(dataDto.getAngle());
            entity.setBaseRefractive(dataDto.getBaseRefractive());
            //entity.setDiffraction(JSON.toJSONString(dataDto.getDiffraction()));
            entity.setInLine(dataDto.getInLine());
            entity.setOrder1(dataDto.getOrder());
            entity.setPeriod(dataDto.getPeriod());
            entity.setPicture(dataDto.getPicture());
            entity.setRefractive(dataDto.getRefractive());
            entity.setDataFrom(dataDto.getDataFrom());
            entity.setImportId(dataDto.getImportId());
            entity.setDataStr(dataFile);
            entity.setCurStatus(1);
            mapper.insert(entity);
        }
    }
}
