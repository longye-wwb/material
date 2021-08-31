package com.crledu.auto.material.infrared.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.cooling.repository.entity.CoolingMaterailEntity;
import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingLayerVo;
import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingVo;
import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.domain.MicrowaveAbsorbingLayerDomain;
import com.crledu.auto.material.infrared.biz.domain.MicrowaveAbsordingLayerImportDataDomain;
import com.crledu.auto.material.infrared.biz.dto.MicrowaveAbsorbingSelectDto;
import com.crledu.auto.material.infrared.biz.repository.BaseMicrowaveAbsordingLayerImportDataDomainRepository;
import com.crledu.auto.material.infrared.repository.dao.BaseAbsorbingLayerDao;
import com.crledu.auto.material.infrared.repository.dao.BaseMicrowaveAbsorbingLayerDao;
import com.crledu.auto.material.infrared.repository.dto.AbsorbingLayerEntityDataDto;
import com.crledu.auto.material.infrared.repository.dto.AbsorbingLayerItemEntityDataDto;
import com.crledu.auto.material.infrared.repository.entity.AbsorbingLayerEntity;
import com.crledu.auto.material.infrared.repository.entity.MicrowaveAbsorbingLayerEntity;
import com.crledu.auto.material.microwaveIntegration.repository.entity.MicrowaveIntegrationEntity;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description:  微波吸收层数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 17:14
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class MicrowaveAbsordingLayerImportDataDomainRepositoryImpl implements BaseMicrowaveAbsordingLayerImportDataDomainRepository {

    @Resource
    private BaseAbsorbingLayerDao absorbingLayerDao;

    @Resource
    private BaseMicrowaveAbsorbingLayerDao microwaveAbsorbingLayerDao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public MicrowaveAbsordingLayerImportDataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public MicrowaveAbsordingLayerImportDataDomain saveInData(MicrowaveAbsordingLayerImportDataDomain domain) {
        List<AbsorbingLayerEntity> layerEntityList = new ArrayList<>();
        List<AbsorbingLayerItemEntityDataDto> layerDataList = new ArrayList<>();
        if(domain.getMicrowaveAbsorbingLayerDomainList() != null || domain.getMicrowaveAbsorbingLayerDomainList().size()>0){
            for(MicrowaveAbsorbingLayerDomain layer:domain.getMicrowaveAbsorbingLayerDomainList()){
                AbsorbingLayerEntity layerEntity = new AbsorbingLayerEntity();
                AbsorbingLayerItemEntityDataDto dataDto = new AbsorbingLayerItemEntityDataDto();
                layerEntity.setBaseDielectric(layer.getBaseDomain().getDielectricConstant());
                dataDto.setBaseDielectric(layer.getBaseDomain().getDielectricConstant());
                layerEntity.setBaseMaterial(layer.getBaseDomain().getMaterial());
                dataDto.setBaseMaterial(layer.getBaseDomain().getMaterial());
                layerEntity.setCurStatus(1);
                dataDto.setCurStatus(1);
                layerEntity.setDielectricConstant(layer.getDielectricDomain().getDielectricConstant());
                dataDto.setDielectricConstant(layer.getDielectricDomain().getDielectricConstant());
                layerEntity.setDielectricMaterial(layer.getDielectricDomain().getMaterial());
                dataDto.setDielectricMaterial(layer.getDielectricDomain().getMaterial());
                layerEntity.setOrd(layerEntityList.size());
                dataDto.setIndex(layerDataList.size());
                layerEntity.setResistance(layer.getFilmResistanceDomain().getResistance());
                dataDto.setResistance(layer.getFilmResistanceDomain().getResistance());
                layerEntity.setShape(layer.getFilmResistanceDomain().getShape());
                dataDto.setShape(layer.getFilmResistanceDomain().getShape());
                layerEntity.setSide(layer.getFilmResistanceDomain().getSideLength());
                dataDto.setSide(layer.getFilmResistanceDomain().getSideLength());
                layerEntity.setThickness(layer.getDielectricDomain().getThickness());
                dataDto.setThickness(layer.getDielectricDomain().getThickness());
                layerEntityList.add(layerEntity);
                layerDataList.add(dataDto);
            }
        }
        AbsorbingLayerEntityDataDto absorbingLayerEntityDataDto = new AbsorbingLayerEntityDataDto();
        absorbingLayerEntityDataDto.setAbsorbingData(JSON.toJSONString(domain.getAbsorbingData()));
        absorbingLayerEntityDataDto.setCurStatus(1);
        absorbingLayerEntityDataDto.setDataFrom(domain.getDataFrom());
        absorbingLayerEntityDataDto.setImportId(domain.getImportId());
        absorbingLayerEntityDataDto.setLightAngle(domain.getLightFrom());
        absorbingLayerEntityDataDto.setPeriod(domain.getPeriod());
        absorbingLayerEntityDataDto.setLayers(layerDataList);
        MicrowaveAbsorbingLayerEntity microwaveAbsorbingLayerEntity = new MicrowaveAbsorbingLayerEntity();
        String fileName = bigdataRepositoryService.saveData(absorbingLayerEntityDataDto,domain.getImportId());
        if(domain.getSaveData()){
            microwaveAbsorbingLayerEntity.setAbsorbingData(fileName);
            microwaveAbsorbingLayerEntity.setCurStatus(1);
            microwaveAbsorbingLayerEntity.setDataFrom(domain.getDataFrom());
            microwaveAbsorbingLayerEntity.setImportId(domain.getImportId());
            microwaveAbsorbingLayerEntity.setLightAngle(domain.getLightFrom());
            microwaveAbsorbingLayerEntity.setPeriod(domain.getPeriod());
            microwaveAbsorbingLayerDao.insert(microwaveAbsorbingLayerEntity);
            for(AbsorbingLayerEntity item:layerEntityList){
                item.setLayerId(microwaveAbsorbingLayerEntity.getId());
                absorbingLayerDao.insert(item);
            }
            return createWithData(microwaveAbsorbingLayerEntity.getId());
        }else{
            return null;
        }
    }

    @Override
    public MicrowaveAbsordingLayerImportDataDomain updateToData(MicrowaveAbsordingLayerImportDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }


    @Override
    public PageDate<MicrowaveAbsorbingVo> selectAbsorbingList(MicrowaveAbsorbingSelectDto selectDto) {
        Page<MicrowaveAbsorbingVo> page = new Page<>(selectDto.getPageNum(),selectDto.getPageSize());
        Page<MicrowaveAbsorbingVo> pageVo = page.setRecords(microwaveAbsorbingLayerDao.selectMicrowaveList(selectDto, page));
        for (MicrowaveAbsorbingVo microwaveAbsorbingVo:pageVo.getRecords()) {
            List<MicrowaveAbsorbingLayerVo> layerVos = absorbingLayerDao.selectVoList(microwaveAbsorbingVo.getId());
            //拼接数据
            microwaveAbsorbingVo.setLayerVos(layerVos);
        }
        return new PageDate<>(pageVo);
    }

    @Override
    public MicrowaveAbsorbingVo selectInfo(Long id) {
        MicrowaveAbsorbingLayerEntity microwaveAbsorbingLayerEntity = microwaveAbsorbingLayerDao.selectById(id);
        QueryWrapper<AbsorbingLayerEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("layer_id",microwaveAbsorbingLayerEntity.getId());
        List<AbsorbingLayerEntity> absorbingLayerEntities = absorbingLayerDao.selectList(queryWrapper);
        MicrowaveAbsorbingVo micvo= new MicrowaveAbsorbingVo();
        List<MicrowaveAbsorbingLayerVo> layerVos = new ArrayList<>();
        BeanUtils.copyProperties(microwaveAbsorbingLayerEntity,micvo);
        for (AbsorbingLayerEntity layerEntity:absorbingLayerEntities){
            MicrowaveAbsorbingLayerVo layerVo = new MicrowaveAbsorbingLayerVo();
            BeanUtils.copyProperties(layerEntity,layerVo);
            layerVos.add(layerVo);
        }
        micvo.setLayerVos(layerVos);
        micvo.setAbsorbingData(bigdataRepositoryService.getDataFile(microwaveAbsorbingLayerEntity.getAbsorbingData()));
        return micvo;
    }

    @Override
    public void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("id");
        absorbingLayerDao.delete(queryWrapper);
        microwaveAbsorbingLayerDao.delete(queryWrapper);
    }
}
