package com.crledu.auto.material.infrared.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.infrared.biz.domain.InfraredProjectionLayerImportDomain;
import com.crledu.auto.material.infrared.biz.repository.BaseInfraredProjectionImportDomainRepository;
import com.crledu.auto.material.infrared.repository.dao.BaseInfraredProjectionDao;
import com.crledu.auto.material.infrared.repository.dto.InfraredProjectionEntityDataDto;
import com.crledu.auto.material.infrared.repository.entity.InfraredProjectionEntity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 红外反射微波透射层数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 14:11
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class InfraredProjectionImportDomainRepositoryImpl implements BaseInfraredProjectionImportDomainRepository {

    @Resource
    private BaseInfraredProjectionDao baseInfraredProjectionDao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public InfraredProjectionLayerImportDomain createWithData(Long id) {
        return null;
    }

    @Override
    public InfraredProjectionLayerImportDomain saveInData(InfraredProjectionLayerImportDomain domain) {
        InfraredProjectionEntityDataDto dataDto = new InfraredProjectionEntityDataDto();
        dataDto.setBaseDielectric(domain.getBaseDomain().getDielectricConstant());
        dataDto.setBaseEmissivity(domain.getBaseDomain().getInfraredEmissivity());
        dataDto.setBaseMaterial(domain.getBaseDomain().getMaterial());
        dataDto.setCurStatus(1);
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setEmissivity(domain.getInfraredEmissivity());
        dataDto.setImportId(domain.getImportId());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setPatchEmissivity(domain.getPatchDomain().getInfraredEmissivity());
        dataDto.setPatchMaterial(domain.getPatchDomain().getMaterial());
        dataDto.setPatchPercent(domain.getPatchDomain().getProportionOfMetals());
        dataDto.setPatchPeriod(domain.getPatchDomain().getPeriod());
        dataDto.setPatchWidth(domain.getPatchDomain().getWide());
        dataDto.setProjectionData(domain.getData());
        String fileName = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            InfraredProjectionEntity projectionEntity = new InfraredProjectionEntity();
            projectionEntity.setBaseDielectric(dataDto.getBaseDielectric());
            projectionEntity.setBaseEmissivity(dataDto.getBaseEmissivity());
            projectionEntity.setBaseMaterial(dataDto.getBaseMaterial());
            projectionEntity.setCurStatus(dataDto.getCurStatus());
            projectionEntity.setDataFrom(dataDto.getDataFrom());
            projectionEntity.setEmissivity(dataDto.getEmissivity());
            projectionEntity.setImportId(dataDto.getImportId());
            projectionEntity.setLightAngle(dataDto.getLightAngle());
            projectionEntity.setPatchEmissivity(dataDto.getPatchEmissivity());
            projectionEntity.setPatchMaterial(dataDto.getPatchMaterial());
            projectionEntity.setPatchPercent(dataDto.getPatchPercent());
            projectionEntity.setPatchPeriod(dataDto.getPatchPeriod());
            projectionEntity.setPatchWidth(dataDto.getPatchWidth());
            projectionEntity.setProjectionData(fileName);
            baseInfraredProjectionDao.insert(projectionEntity);
            return createWithData(projectionEntity.getId());
        }else{
            return domain;
        }

    }

    @Override
    public InfraredProjectionLayerImportDomain updateToData(InfraredProjectionLayerImportDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }
}
