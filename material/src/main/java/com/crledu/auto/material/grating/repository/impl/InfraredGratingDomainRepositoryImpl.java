package com.crledu.auto.material.grating.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.grating.biz.domain.InfraredGratingDomain;
import com.crledu.auto.material.grating.biz.repository.BaseInfraredGratingDomainRepository;
import com.crledu.auto.material.grating.repository.dao.BaseInfraredGratingMapper;
import com.crledu.auto.material.grating.repository.dto.InfraredGratingDataDto;
import com.crledu.auto.material.grating.repository.entity.InfraredGratingEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description:  红外光栅数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 10:34
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class InfraredGratingDomainRepositoryImpl implements BaseInfraredGratingDomainRepository {

    @Resource
    private BaseInfraredGratingMapper gratingMapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public InfraredGratingDomain createWithData(Long id) {
        return null;
    }

    @Override
    public InfraredGratingDomain saveInData(InfraredGratingDomain domain) {
        InfraredGratingDataDto infraredGratingDataDto = new InfraredGratingDataDto();
        infraredGratingDataDto.setAbsorbingItemDtos(domain.getAbsorbingItemDtos());
        infraredGratingDataDto.setDataFrom(domain.getDataFrom());
        infraredGratingDataDto.setHeight(domain.getHeight());
        infraredGratingDataDto.setImportId(domain.getImportId());
        infraredGratingDataDto.setLightAngle(domain.getLightAngle());
        infraredGratingDataDto.setSpace(domain.getSpace());
        infraredGratingDataDto.setWidth(domain.getWidth());
        infraredGratingDataDto.setMaterial(domain.getMaterial());
        infraredGratingDataDto.setLightType(domain.getLightType());
        infraredGratingDataDto.setBandwidth(domain.getBandwidth());
        String dataFile = bigdataRepositoryService.saveData(infraredGratingDataDto,domain.getImportId());
        if(domain.getSaveData()){
            InfraredGratingEntity gratingEntity = new InfraredGratingEntity();
            gratingEntity.setCurStatus(1);
            gratingEntity.setData(dataFile);
            gratingEntity.setHeight(infraredGratingDataDto.getHeight());
            gratingEntity.setLightAngle(infraredGratingDataDto.getLightAngle());
            gratingEntity.setSpaces(infraredGratingDataDto.getSpace());
            gratingEntity.setWidth(infraredGratingDataDto.getWidth());
            gratingEntity.setDataFrom(infraredGratingDataDto.getDataFrom());
            gratingEntity.setMaterial(infraredGratingDataDto.getMaterial());
            gratingEntity.setImportId(infraredGratingDataDto.getImportId());
            gratingEntity.setLightType(infraredGratingDataDto.getLightType());
            gratingEntity.setBandwidth(infraredGratingDataDto.getBandwidth());
            gratingMapper.insert(gratingEntity);
            return createWithData(gratingEntity.getId());
        }else{
            return null;
        }
    }

    @Override
    public InfraredGratingDomain updateToData(InfraredGratingDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }
}
