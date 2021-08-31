package com.crledu.auto.material.infrared.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.domain.ProjectionLayerDomain;
import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionLayerImportDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionSelectDto;
import com.crledu.auto.material.infrared.biz.repository.BaseProjectionLayerDomainRepository;
import com.crledu.auto.material.infrared.repository.dao.BaseProjectionLayerDao;
import com.crledu.auto.material.infrared.repository.dto.ProjectionMaterialEntityDataDto;
import com.crledu.auto.material.infrared.repository.entity.ProjectionLayerEntity;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 红外反射微波透射层业务数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 17:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class ProjectionLayerDomainRepositoryImpl implements BaseProjectionLayerDomainRepository {

    @Resource
    private BaseProjectionLayerDao projectionLayerDao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public ProjectionLayerDomain createWithData(Long id) {
        return null;
    }

    @Override
    public ProjectionLayerDomain saveInData(ProjectionLayerDomain domain)
    {
        ProjectionMaterialEntityDataDto dataDto = new ProjectionMaterialEntityDataDto();
        dataDto.setBaseDielectric(domain.getBaseDomain().getDielectricConstant());
        dataDto.setBaseEmissivity(domain.getBaseDomain().getInfraredEmissivity());
        dataDto.setBaseMaterial(domain.getBaseDomain().getMaterial());
        dataDto.setCurStatus(1);
        dataDto.setDataFrom(domain.getDataFrom());
        dataDto.setDielectricConstant(domain.getDielectricDomain().getDielectricConstant());
        dataDto.setDielectricEmissivity(domain.getDielectricDomain().getInfraredEmissivity());
        dataDto.setDielectricMaterial(domain.getDielectricDomain().getMaterial());
        dataDto.setDielectricThickness(domain.getDielectricDomain().getThickness());
        dataDto.setEmissivity(domain.getInfraredEmissivity());
        dataDto.setImportId(domain.getImportId());
        dataDto.setLightAngle(domain.getLightAngle());
        dataDto.setPatchEmissivity(domain.getMetalPatchDomain().getInfraredEmissivity());
        dataDto.setPatchMaterial(domain.getMetalPatchDomain().getMaterial());
        dataDto.setPatchPercent(domain.getMetalPatchDomain().getProportionOfMetals());
        dataDto.setPatchPeriod(domain.getMetalPatchDomain().getPeriod());
        dataDto.setPatchWidth(domain.getMetalPatchDomain().getWide());
        dataDto.setProjectionData(JSON.toJSONString(domain.getProjectionDataItemDtoList()));
        String dataFlie = bigdataRepositoryService.saveData(dataDto,domain.getImportId());
        if(domain.getSaveData()){
            ProjectionLayerEntity entity = new ProjectionLayerEntity();
            entity.setBaseDielectric(domain.getBaseDomain().getDielectricConstant());
            entity.setBaseEmissivity(domain.getBaseDomain().getInfraredEmissivity());
            entity.setBaseMaterial(domain.getBaseDomain().getMaterial());
            entity.setCurStatus(1);
            entity.setDataFrom(domain.getDataFrom());
            entity.setDielectricConstant(domain.getDielectricDomain().getDielectricConstant());
            entity.setDielectricEmissivity(domain.getDielectricDomain().getInfraredEmissivity());
            entity.setDielectricMaterial(domain.getDielectricDomain().getMaterial());
            entity.setDielectricThickness(domain.getDielectricDomain().getThickness());
            entity.setEmissivity(domain.getInfraredEmissivity());
            entity.setImportId(domain.getImportId());
            entity.setLightAngle(domain.getLightAngle());
            entity.setPatchEmissivity(domain.getMetalPatchDomain().getInfraredEmissivity());
            entity.setPatchMaterial(domain.getMetalPatchDomain().getMaterial());
            entity.setPatchPercent(domain.getMetalPatchDomain().getProportionOfMetals());
            entity.setPatchPeriod(domain.getMetalPatchDomain().getPeriod());
            entity.setPatchWidth(domain.getMetalPatchDomain().getWide());
            entity.setProjectionData(dataFlie);
            projectionLayerDao.insert(entity);
            return createWithData(entity.getId());
        }else {
            return null;
        }
    }

    @Override
    public ProjectionLayerDomain updateToData(ProjectionLayerDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    @Override
    public PageDate<ProjectionVo> selectProjectionList(ProjectionSelectDto projectionSelectDto) {
        Page<ProjectionVo> page = new Page<>(projectionSelectDto.getPageNum(),projectionSelectDto.getPageSize());
        page.setRecords( projectionLayerDao.selectProjectionList(projectionSelectDto,page));
        return new PageDate<>(page);

    }

    @Override
    public ProjectionVo selectInfo(Long id) {
        ProjectionLayerEntity projectionLayerEntity = projectionLayerDao.selectById(id);
        ProjectionVo projectionVo = new ProjectionVo();
        BeanUtils.copyProperties(projectionLayerEntity,projectionVo);
        projectionVo.setProjectionData(bigdataRepositoryService.getDataFile(projectionLayerEntity.getProjectionData()));
        return projectionVo;
    }

    @Override
    public void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        projectionLayerDao.delete(queryWrapper);
    }
}
