package com.crledu.auto.material.microw.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseItemDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseSelectParamDto;
import com.crledu.auto.material.microw.data.service.BaseMicrowavePhaseDataService;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowavePhaseDao;
import com.crledu.auto.material.microw.repository.entity.MicrowavePhaseEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波相位调控数据检索服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:15
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class MicrowavePhaseDataServiceImpl implements BaseMicrowavePhaseDataService {

    @Resource
    private BaseMicrowavePhaseDao dao;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<MicrowavePhaseItemDto> selectPage(MicrowavePhaseSelectParamDto selectParamDto) {
        counterService.addVisiter(DataTypeEnum.MICRO_PHASE);
        Page<MicrowavePhaseEntity> page = new Page<>(selectParamDto.getPageNum(),selectParamDto.getPageSize());
        QueryWrapper<MicrowavePhaseEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getArmr(),"armr");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getArmy(),"army");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLaylerx(),"latlerx");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getPeriod(),"period");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getPermittivity(),"permittivity");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getRectx(),"rectx");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getRectx2(),"rectx2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getSubh(),"subh");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getRecty(),"recty");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getThickness(),"thickness");
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getDataFrom()),"data_from",selectParamDto.getDataFrom());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getWorkingMode()),"working_mode",selectParamDto.getWorkingMode());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getLightType()),"light_type",selectParamDto.getLightType());
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getBandwidth(),"bandwidth");
        page = dao.selectPage(page,queryWrapper);
        List<MicrowavePhaseItemDto> rows = new ArrayList<>();
        if(ObjectUtils.isNotNull(page.getRecords())){
            for(MicrowavePhaseEntity entity: page.getRecords()){
                MicrowavePhaseItemDto itemDto = new MicrowavePhaseItemDto();
                BeanUtils.copyProperties(entity,itemDto);
                itemDto.setBandwidth(entity.getBandwidth());
                rows.add(itemDto);
            }
        }
        return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
    }

    @Override
    public MicrowavePhaseInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.MICRO_PHASE);
        MicrowavePhaseEntity entity = dao.selectById(id);
        if(entity != null){
            MicrowavePhaseInfoDto infoDto = new MicrowavePhaseInfoDto();
            BeanUtils.copyProperties(entity,infoDto);
            String fileData = baseBigdataRepositoryService.getDataFile(entity.getData());
            infoDto.setDataArr(fileData);
            return infoDto;
        }
        return null;
    }
}
