package com.crledu.auto.material.grating.data.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.base.dto.lineDataItemDto;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.grating.api.vo.InfraredGratingSelectParamVo;
import com.crledu.auto.material.grating.data.dto.InfraredGratingInfoDto;
import com.crledu.auto.material.grating.data.dto.InfraredGratingItemDto;
import com.crledu.auto.material.grating.data.service.BaseInfraredGratingDataService;
import com.crledu.auto.material.grating.repository.dao.BaseInfraredGratingMapper;
import com.crledu.auto.material.grating.repository.entity.InfraredGratingEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.util.web.StringParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 红外窄带传感数据查询
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 9:29
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredGratingDataServiceImpl implements BaseInfraredGratingDataService {

    @Resource
    private BaseInfraredGratingMapper infraredGratingMapper;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<InfraredGratingItemDto> selectPage(InfraredGratingSelectParamVo paramVo) {
        counterService.addVisiter(DataTypeEnum.INFRARED_GRATING);
        Page<InfraredGratingEntity> page = new Page<>(paramVo.getPageNum(),paramVo.getPageSize());
        QueryWrapper<InfraredGratingEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getHeight(),"height");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getSpace(),"spaces");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getWidth(),"width");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,paramVo.getMaterial(),"material");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getBandwidth(),"bandwidth");
        queryWrapper.eq(ObjectUtils.isNotNull(paramVo.getLightType()),"light_type",paramVo.getLightType());
        page = infraredGratingMapper.selectPage(page,queryWrapper);
        if(ObjectUtils.isNotNull(page.getRecords())){
            List<InfraredGratingItemDto> rows = new ArrayList<>();
            for(InfraredGratingEntity entity:page.getRecords()){
                InfraredGratingItemDto itemDto = new InfraredGratingItemDto();
                itemDto.setDataFrom(entity.getDataFrom());
                itemDto.setHeight(entity.getHeight());
                itemDto.setId(entity.getId());
                itemDto.setImportId(entity.getImportId());
                itemDto.setLightAngle(entity.getLightAngle());
                itemDto.setSpaces(entity.getSpaces());
                itemDto.setWidth(entity.getWidth());
                itemDto.setMaterial(entity.getMaterial());
                itemDto.setBandwidth(entity.getBandwidth());
                itemDto.setLightType(entity.getLightType());
                rows.add(itemDto);
            }
            PageDate<InfraredGratingItemDto> result = new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
            return result;
        }else {
            return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),new ArrayList<>());
        }
    }

    @Override
    public InfraredGratingInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.INFRARED_GRATING);
        InfraredGratingEntity infraredGratingEntity = infraredGratingMapper.selectById(id);
        InfraredGratingInfoDto infraredGratingInfoDto = new InfraredGratingInfoDto();
        String dataFile = baseBigdataRepositoryService.getDataFile(infraredGratingEntity.getData());
        infraredGratingInfoDto.setData(dataFile);
        infraredGratingInfoDto.setDataFrom(infraredGratingEntity.getDataFrom());
        infraredGratingInfoDto.setHeight(infraredGratingEntity.getHeight());
        infraredGratingInfoDto.setId(infraredGratingEntity.getId());
        infraredGratingInfoDto.setImportId(infraredGratingEntity.getImportId());
        infraredGratingInfoDto.setLightAngle(infraredGratingEntity.getLightAngle());
        infraredGratingInfoDto.setSpaces(infraredGratingEntity.getSpaces());
        infraredGratingInfoDto.setWidth(infraredGratingEntity.getWidth());
        infraredGratingInfoDto.setLightType(infraredGratingEntity.getLightType());
        infraredGratingInfoDto.setMaterial(infraredGratingEntity.getMaterial());
        infraredGratingInfoDto.setBandwidth(infraredGratingEntity.getBandwidth());
        return infraredGratingInfoDto;
    }
}
