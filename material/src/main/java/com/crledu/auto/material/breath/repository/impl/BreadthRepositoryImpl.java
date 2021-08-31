package com.crledu.auto.material.breath.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.breath.biz.domain.BreadthDomain;
import com.crledu.auto.material.breath.biz.repository.BreadthRepository;
import com.crledu.auto.material.breath.repository.dao.BreadthMapper;
import com.crledu.auto.material.breath.repository.dto.BreadthDataDto;
import com.crledu.auto.material.breath.repository.entity.BreadthEntity;
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
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Repository
public class BreadthRepositoryImpl implements BreadthRepository {

    @Resource
    private BreadthMapper breadthMapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveIndata(BreadthDomain domain) {
        BreadthDataDto dateDto= new BreadthDataDto();
        dateDto.setBaseMaterial(domain.getBaseDomain().getMaterial());
        dateDto.setBaseThickness(domain.getBaseDomain().getThickness());
        dateDto.setWaveDtos(domain.getWaveDtos());
        dateDto.setDataFrom(domain.getDataFrom());
        dateDto.setDielectric(domain.getMediumDomain().getDielectric());
        dateDto.setLength(domain.getStructureDomain().getLength());
        dateDto.setLightAngle(domain.getLightAngle());
        dateDto.setLoss(domain.getMediumDomain().getLoss());
        dateDto.setMediumMaterial(domain.getMediumDomain().getMaterial());
        dateDto.setMediumThickness(domain.getMediumDomain().getThickness());
        dateDto.setPeriod(domain.getStructureDomain().getPeriod());
        dateDto.setStructureMaterial(domain.getStructureDomain().getMaterial());
        dateDto.setStructureThickness(domain.getStructureDomain().getThickness());
        dateDto.setType(domain.getStructureDomain().getType());
        dateDto.setWidth(domain.getStructureDomain().getWidth());
        dateDto.setWorkingBand(domain.getWorkingBand());
        dateDto.setImportId(domain.getImportId());
        dateDto.setWorkMode(domain.getWorkMode());
        dateDto.setLightType(domain.getLightType());
        dateDto.setBandwidth(domain.getBandwidth());
        String dataFile = bigdataRepositoryService.saveData(dateDto,domain.getImportId());
        if(domain.getSaveData()){
            BreadthEntity entity = new BreadthEntity();
            entity.setBaseMaterial(dateDto.getBaseMaterial());
            entity.setBaseThickness(dateDto.getBaseThickness());
            entity.setData(dataFile);
            entity.setDataFrom(dateDto.getDataFrom());
            entity.setDielectric(dateDto.getDielectric());
            entity.setLength(dateDto.getLength());
            entity.setLightAngle(dateDto.getLightAngle());
            entity.setLoss(dateDto.getLoss());
            entity.setMediumMaterial(dateDto.getMediumMaterial());
            entity.setMediumThickness(dateDto.getMediumThickness());
            entity.setPeriod(dateDto.getPeriod());
            entity.setStructureMaterial(dateDto.getStructureMaterial());
            entity.setStructureThickness(dateDto.getStructureThickness());
            entity.setType(dateDto.getType());
            entity.setWidth(dateDto.getWidth());
            entity.setWorkingBand(dateDto.getWorkingBand());
            entity.setImportId(dateDto.getImportId());
            entity.setLightType(dateDto.getLightType());
            entity.setWorkMode(dateDto.getWorkMode());
            entity.setBandwidth(dateDto.getBandwidth());
            breadthMapper.insert(entity);
        }
    }
}
