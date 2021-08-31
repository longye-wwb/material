package com.crledu.auto.material.second.repository.impl;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.second.biz.domain.BoundaryDomain;
import com.crledu.auto.material.second.biz.repository.BaseBoundaryRepository;
import com.crledu.auto.material.second.repository.dao.BaseBoundaryMapper;
import com.crledu.auto.material.second.repository.dto.BoundaryDataDto;
import com.crledu.auto.material.second.repository.entity.BoundaryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 边界优化超透镜业务对象数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:37
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class BoundaryRepositoryImpl implements BaseBoundaryRepository {

    @Resource
    private BaseBoundaryMapper mapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveInData(BoundaryDomain domain) {
        BoundaryDataDto dataDto = new BoundaryDataDto();
        dataDto.setBaseConstant(domain.getBaseConstant());
        dataDto.setBaseShape(domain.getBaseShape());
        dataDto.setConstant(domain.getConstant());
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setDiffractionEfficiency(domain.getDiffractionEfficiency());
        dataDto.setFocalEfficiency(domain.getFocalEfficiency());
        dataDto.setFocalLength(domain.getFocalLength());
        dataDto.setH1(domain.getH1());
        dataDto.setH2(domain.getH2());
        dataDto.setHopefulDiffractionEfficiency(domain.getHopefulDiffractionEfficiency());
        dataDto.setHopefulFocalEfficiency(domain.getHopefulFocalEfficiency());
        dataDto.setImportId(domain.getImportId());
        dataDto.setL(domain.getL());
        dataDto.setLength(domain.getLength());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setLightType(domain.getLightType());
        dataDto.setP(domain.getP());
        dataDto.setShape(domain.getShape());
        dataDto.setTransmittance(domain.getTransmittance());
        dataDto.setType(domain.getType());
        dataDto.setWorkingWave(domain.getWorkingWave());
        dataDto.setWorkType(domain.getWorkType());
        dataDto.setCenterX(domain.getCenterX());
        dataDto.setCentery(domain.getCentery());
        dataDto.setLightData(domain.getLightData());
        String dataFile = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            BoundaryEntity entity = new BoundaryEntity();
            BeanUtils.copyProperties(dataDto,entity);
            entity.setData(dataFile);
            mapper.insert(entity);
        }

    }
}
