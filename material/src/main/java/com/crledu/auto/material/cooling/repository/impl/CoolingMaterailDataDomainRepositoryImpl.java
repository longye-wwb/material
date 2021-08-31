package com.crledu.auto.material.cooling.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailDataDomain;
import com.crledu.auto.material.cooling.biz.domain.MaterailLayerDomain;
import com.crledu.auto.material.cooling.biz.dto.*;
import com.crledu.auto.material.cooling.biz.repository.BaseCoolingMaterailDataDomainRepository;
import com.crledu.auto.material.cooling.repository.dao.BaseCoolingMaterailMapper;
import com.crledu.auto.material.cooling.repository.entity.CoolingMaterailEntity;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.*;

/**
 ************************************************************
 * @Description: 辐射制冷业务对象的实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 14:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class CoolingMaterailDataDomainRepositoryImpl implements BaseCoolingMaterailDataDomainRepository {

    @Resource
    private BaseCoolingMaterailMapper coolingMaterialMapper;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public CoolingMaterailDataDomain createWithData(Long id) {
        CoolingMaterailEntity entity = coolingMaterialMapper.selectById(id);
        if(entity != null){
            File dataFile = new File(entity.getAbsorptivity());
            try{
                String text = "";
                BufferedReader reader = new BufferedReader(new FileReader(dataFile));
                String buffer = null;
                while ((buffer = reader.readLine()) != null){
                    text += buffer;
                }
                CoolingMaterialInfoDto infoDto = JSON.parseObject(text,CoolingMaterialInfoDto.class);
                CoolingMaterailDataDomain dataDomain = new CoolingMaterailDataDomain(entity.getId(),entity.getImportId(),entity.getType(),entity.getThickness(),entity.getPeriod(), JSON.parseObject(entity.getBase(), MaterailLayerDomain.class),JSON.parseArray(entity.getLayer(),MaterailLayerDomain.class),entity.getLightType(),entity.getDataFrom(),entity.getLightAngle(),entity.getWorkingMode(),JSON.parseArray(infoDto.getAbs(), AbsorbingItemDto.class));
                return dataDomain;
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public CoolingMaterailDataDomain saveInData(CoolingMaterailDataDomain domain) {
        //辐射制冷大数据保存
        CoolingMaterialInfoDto infoDto = new CoolingMaterialInfoDto();
        infoDto.setAbs(JSON.toJSONString(domain.getAbsorptivity()));
        infoDto.setBase(JSON.toJSONString(domain.getBaseMaterial()));
        infoDto.setDataFrom(domain.getDataForm());
        infoDto.setId(null);
        infoDto.setLayer(JSON.toJSONString(domain.getLayers()));
        infoDto.setLightAngle(domain.getLightAngle());
        infoDto.setLightType(domain.getLightType());
        infoDto.setThickness(domain.getThickness());
        infoDto.setType(domain.getType());
        infoDto.setWorkingMode(domain.getWorkingMode());
        infoDto.setPeriod(domain.getPeriod());
        String file = bigdataRepositoryService.saveData(infoDto,domain.getImportId());
        //保存材料导数据库
        if(domain.getSaveData()){
            CoolingMaterailEntity coolingMaterailEntity = new CoolingMaterailEntity();
            coolingMaterailEntity.setAbsorptivity(file);
            coolingMaterailEntity.setBase(infoDto.getBase());
            coolingMaterailEntity.setDataFrom(infoDto.getDataFrom());
            coolingMaterailEntity.setLayer(infoDto.getLayer());
            coolingMaterailEntity.setLightAngle(infoDto.getLightAngle());
            coolingMaterailEntity.setLightType(infoDto.getLightType());
            coolingMaterailEntity.setThickness(infoDto.getThickness());
            coolingMaterailEntity.setType(infoDto.getType());
            coolingMaterailEntity.setWorkingMode(infoDto.getWorkingMode());
            coolingMaterailEntity.setBaseMaterial(domain.getBaseMaterial().getMaterail());
            coolingMaterailEntity.setFirstMaterial(domain.getLayers().get(0).getMaterail());
            if(domain.getLayers().size()>1){
                coolingMaterailEntity.setSecondMaterial(domain.getLayers().get(1).getMaterail());
            }
            coolingMaterailEntity.setMaxWavelength(domain.getAbsorptivity().get(domain.getAbsorptivity().size()-1).getWaveLength());
            coolingMaterailEntity.setMinWavelength(domain.getAbsorptivity().get(0).getWaveLength());
            coolingMaterailEntity.setImportId(domain.getImportId());
            coolingMaterailEntity.setLayerAmount(domain.getLayers().size());
            coolingMaterailEntity.setPeriod(domain.getPeriod());
            coolingMaterialMapper.insert(coolingMaterailEntity);
            return createWithData(coolingMaterailEntity.getId());
        }else{
            return domain;
        }
    }

    @Override
    public CoolingMaterailDataDomain updateToData(CoolingMaterailDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    @Override
    public PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto) {
        Page<CoolingMaterialItemDto> page = new Page<>(selectDto.getPageNum(),selectDto.getPageSize());
        page.setRecords(coolingMaterialMapper.selectCoolingMaterial(selectDto,page));
        return new PageDate<>(page);
    }

    @Override
    public CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto) {
        CoolingMaterailEntity entity = coolingMaterialMapper.selectById(selectDto.getId());
        if(entity != null){
            File dataFile = new File(entity.getAbsorptivity());
            try{
                String text = "";
                BufferedReader reader = new BufferedReader(new FileReader(dataFile));
                String buffer = null;
                while ((buffer = reader.readLine()) != null){
                    text += buffer;
                }
                CoolingMaterialInfoDto infoDto = JSON.parseObject(text,CoolingMaterialInfoDto.class);
                infoDto.setId(entity.getId());
                return infoDto;
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
