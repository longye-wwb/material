package com.crledu.auto.material.microwaveIntegration.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microwave.repository.dto.MicrowaveDataDto;
import com.crledu.auto.material.microwaveIntegration.biz.domain.MicrowaveInterationDomain;
import com.crledu.auto.material.microwaveIntegration.biz.repository.MicrowaveIntegrationRepository;
import com.crledu.auto.material.microwaveIntegration.repository.dao.MicrowaveIntegrationMapper;
import com.crledu.auto.material.microwaveIntegration.repository.dto.MicrowaveIntegrationDataDto;
import com.crledu.auto.material.microwaveIntegration.repository.entity.MicrowaveIntegrationEntity;
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
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Repository
public class MicrowaveIntegrationRepositoryImpl implements MicrowaveIntegrationRepository {

    @Resource
    private MicrowaveIntegrationMapper microwaveIntegrationMapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveInData(MicrowaveInterationDomain domain) {
        MicrowaveIntegrationDataDto dataDto = new MicrowaveIntegrationDataDto();
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setDielectric(domain.getDielectric());
        dataDto.setEndFrequency(domain.getEndFrequency());
        dataDto.setP(domain.getP());
        dataDto.setG(domain.getG());
        dataDto.setG0(domain.getG0());
        dataDto.setH(domain.getH());
        dataDto.setH1(domain.getH1());
        dataDto.setH2(domain.getH2());
        dataDto.setH3(domain.getH3());
        dataDto.setImportId(domain.getImportId());
        dataDto.setL(domain.getL());
        dataDto.setL0(domain.getL0());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setLightType(domain.getLightType());
        dataDto.setP(domain.getP());
        dataDto.setR(domain.getR());
        dataDto.setR1(domain.getR1());
        dataDto.setR2(domain.getR2());
        dataDto.setR3(domain.getR3());
        dataDto.setStartFrequency(domain.getStartFrequency());
        dataDto.setWorkType(domain.getWorkType());
        dataDto.setS(domain.getS());
        dataDto.setS1(domain.getS1());
        dataDto.setS2(domain.getS2());
        dataDto.setS3(domain.getS3());
        dataDto.settBandwidth(domain.gettBandwidth());
        dataDto.setaBandwidth(domain.getaBandwidth());
        dataDto.setIntegrationDtos(domain.getIntegrationDtos());
        String data = bigdataRepositoryService.saveData(dataDto, domain.getImportId());
        if(domain.getSaveData()){
            MicrowaveIntegrationEntity entity = new MicrowaveIntegrationEntity();
            entity.setDataFrom(dataDto.getDataFrom());
            entity.setData(data);
            entity.setDielectric(dataDto.getDielectric());
            entity.setEndFrequency(dataDto.getEndFrequency());
            entity.setP(dataDto.getP());
            entity.setG(dataDto.getG());
            entity.setG0(dataDto.getG0());
            entity.setH(dataDto.getH());
            entity.setH1(dataDto.getH1());
            entity.setH2(dataDto.getH2());
            entity.setH3(dataDto.getH3());
            entity.setImportId(dataDto.getImportId());
            entity.setL(dataDto.getL());
            entity.setL0(dataDto.getL0());
            entity.setLightAngle(dataDto.getLightAngle());
            entity.setLightType(dataDto.getLightType());
            entity.setP(dataDto.getP());
            entity.setR1(dataDto.getR1());
            entity.setR(dataDto.getR());
            entity.setR2(dataDto.getR2());
            entity.setR3(dataDto.getR3());
            entity.setStartFrequency(dataDto.getStartFrequency());
            entity.setWorkType(dataDto.getWorkType());
            entity.setS(dataDto.getS());
            entity.setS1(dataDto.getS1());
            entity.setS2(dataDto.getS2());
            entity.setS3(dataDto.getS3());
            entity.settBandwidth(dataDto.gettBandwidth());
            entity.setaBandwidth(dataDto.getaBandwidth());
            microwaveIntegrationMapper.insert(entity);
        }
    }
}
