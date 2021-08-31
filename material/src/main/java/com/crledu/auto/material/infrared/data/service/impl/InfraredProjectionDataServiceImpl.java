package com.crledu.auto.material.infrared.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionInfoDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionItemDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionSelectParamDto;
import com.crledu.auto.material.infrared.data.service.BaseInfraredProjectionDataService;
import com.crledu.auto.material.infrared.repository.dao.BaseInfraredProjectionDao;
import com.crledu.auto.material.infrared.repository.entity.InfraredProjectionEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.util.web.StringParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波红外一体化服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 9:22
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredProjectionDataServiceImpl implements BaseInfraredProjectionDataService {

    @Resource
    private BaseInfraredProjectionDao dao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<InfraredProjectionItemDto> selectPage(InfraredProjectionSelectParamDto selectParam) {
        counterService.addVisiter(DataTypeEnum.INFRARED_PROJECTION);
        Page<InfraredProjectionEntity> page = new Page<>(selectParam.getPageNum(),selectParam.getPageSize());
        QueryWrapper<InfraredProjectionEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getBaseConstant(),"base_dielectric");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getBaseEmissivity(),"base_emissivity");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getBaseThickness(),"base_thickness");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getPatchPeriod(),"patch_period");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getPatchEmissivity(),"patch_emissivity");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getPatchThickness(),"patch_thickness");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getPatchWidth(),"patch_width");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getPercent(),"patch_percent");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,selectParam.getBaseMaterial(),"base_material");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,selectParam.getPatchMaterial(),"patch_material");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParam.getEmissivity(),"emissivity");
        page = dao.selectPage(page,queryWrapper);
        List<InfraredProjectionItemDto> rows = new ArrayList<>();
        if(page.getRecords() != null){
            for(InfraredProjectionEntity entity:page.getRecords()){
                InfraredProjectionItemDto item = new InfraredProjectionItemDto();
                buildByEntity(item,entity);
                rows.add(item);
            }
        }
        PageDate<InfraredProjectionItemDto> result = new PageDate<>(page.getTotal(),IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
        return result;
    }

    private void buildByEntity(InfraredProjectionItemDto itemDto,InfraredProjectionEntity entity){
        itemDto.setBaseDielectric(entity.getBaseDielectric());
        itemDto.setBaseEmissivity(entity.getBaseEmissivity());
        itemDto.setBaseMaterial(entity.getBaseMaterial());
        itemDto.setBaseThickness(entity.getBaseThickness());
        itemDto.setDataFrom(entity.getDataFrom());
        itemDto.setEmissivity(entity.getEmissivity());
        itemDto.setId(entity.getId());
        itemDto.setImportId(entity.getImportId());
        itemDto.setLightAngle(entity.getLightAngle());
        itemDto.setPatchEmissivity(entity.getPatchEmissivity());
        itemDto.setPatchMaterial(entity.getPatchMaterial());
        itemDto.setPatchPercent(entity.getPatchPercent());
        itemDto.setPatchPeriod(entity.getPatchPeriod());
        itemDto.setPatchWidth(entity.getPatchWidth());
    }

    @Override
    public InfraredProjectionInfoDto findInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.INFRARED_PROJECTION);
        InfraredProjectionEntity entity = dao.selectById(id);
        if(entity != null){
            InfraredProjectionInfoDto infoDto = new InfraredProjectionInfoDto();
            buildByEntity(infoDto,entity);
            String data = bigdataRepositoryService.getDataFile(entity.getProjectionData());
            infoDto.setProjection(data);
            return infoDto;
        }else{
            return null;
        }
    }
}
