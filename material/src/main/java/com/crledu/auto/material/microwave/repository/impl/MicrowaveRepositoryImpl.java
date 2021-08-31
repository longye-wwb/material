package com.crledu.auto.material.microwave.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microwave.biz.domain.MicrowaveAbsorbingDomain;
import com.crledu.auto.material.microwave.biz.repository.MicrowaveRepository;
import com.crledu.auto.material.microwave.repository.dao.MicrowaveBroadbandMapper;
import com.crledu.auto.material.microwave.repository.dto.MicrowaveDataDto;
import com.crledu.auto.material.microwave.repository.entity.MicrowaveAbsorbEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Repository
public class MicrowaveRepositoryImpl implements MicrowaveRepository {

    @Resource
    private MicrowaveBroadbandMapper mapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveInData(MicrowaveAbsorbingDomain domain) {
        MicrowaveDataDto dataDto = new MicrowaveDataDto();
        dataDto.setAbsorptionRateDtos(domain.getAbsorptionRateDtos());
        dataDto.setEndWave(domain.getEndWave());
        dataDto.setFiller(domain.getFiller());
        dataDto.setLayer(domain.getLayer());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setLightType(domain.getLightType());
        dataDto.setMaterialStructure(domain.getMaterialStructure());
        dataDto.setP(domain.getP());
        dataDto.setG(domain.getG());
        dataDto.setS3(domain.getS3());
        dataDto.setS1(domain.getS1());
        dataDto.setS2(domain.getS2());
        dataDto.setH1(domain.getH1());
        dataDto.setH2(domain.getH2());
        dataDto.setH3(domain.getH3());
        dataDto.setRs1(domain.getRs1());
        dataDto.setRs2(domain.getRs2());
        dataDto.setRs3(domain.getRs3());
        dataDto.setStartWave(domain.getStartWave());
        dataDto.setTotalThickness(domain.getTotalThickness());
        dataDto.setWorkType(domain.getWorkType());
        dataDto.setImportId(domain.getImportId());
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setBandwidth(domain.getBandwidth());
        String data = bigdataRepositoryService.saveData(dataDto, domain.getImportId());
        if(domain.getSaveData()){
            MicrowaveAbsorbEntity entity = new MicrowaveAbsorbEntity();
            entity.setData(data);
            entity.setDataFrom(dataDto.getDataFrom());
            entity.setEndWave(dataDto.getEndWave());
            entity.setFiller(dataDto.getFiller());
            entity.setLayer(dataDto.getLayer());
            entity.setLightAngle(dataDto.getLightAngle());
            entity.setLightType(dataDto.getLightType());
            entity.setMaterialStructure(dataDto.getMaterialStructure());
            entity.setP(dataDto.getP());
            entity.setG(dataDto.getG());
            entity.setS1(dataDto.getS1());
            entity.setS2(dataDto.getS2());
            entity.setS3(dataDto.getS3());
            entity.setH1(dataDto.getH1());
            entity.setH2(dataDto.getH2());
            entity.setH3(dataDto.getH3());
            entity.setRs1(dataDto.getRs1());
            entity.setRs2(dataDto.getRs2());
            entity.setRs3(dataDto.getRs3());
            entity.setStartWave(dataDto.getStartWave());
            entity.setTotalThickness(dataDto.getTotalThickness());
            entity.setWorkType(dataDto.getWorkType());
            entity.setImportId(dataDto.getImportId());
            entity.setBandwidth(dataDto.getBandwidth());
            mapper.insert(entity);
        }
    }


}
