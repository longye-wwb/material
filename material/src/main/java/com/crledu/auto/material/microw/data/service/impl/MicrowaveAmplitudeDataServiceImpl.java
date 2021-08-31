package com.crledu.auto.material.microw.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.microw.data.dto.MicrowAmplitudeSelectParamDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeItemDto;
import com.crledu.auto.material.microw.data.service.BaseMicrowaveAmplitudeDataService;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowaveAmplitudeDao;
import com.crledu.auto.material.microw.repository.entity.MicrowaveAmplitudeEntity;
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
 * @Description: 微波宽带振幅转换查询服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class MicrowaveAmplitudeDataServiceImpl implements BaseMicrowaveAmplitudeDataService {

    @Resource
    private BaseMicrowaveAmplitudeDao amplitudeDao;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<MicrowaveAmplitudeItemDto> selectPage(MicrowAmplitudeSelectParamDto selectParamDto) {
        counterService.addVisiter(DataTypeEnum.MICRO_AMPLITUDE);
        Page<MicrowaveAmplitudeEntity> page = new Page<>(selectParamDto.getPageNum(),selectParamDto.getPageSize());
        QueryWrapper<MicrowaveAmplitudeEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getConstant(),"constant");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getGap(),"gap");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLineLength(),"length");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLineWidth(),"width");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getThickness(),"thickness");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getWidth(),"width_length");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getXpath(),"xpath");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getYpath(),"ypath");
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getAmplitudeType()),"amplitude_type",selectParamDto.getAmplitudeType());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getDataFrom()),"data_from",selectParamDto.getDataFrom());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getWorkingMode()),"working_mode",selectParamDto.getWorkingMode());
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getBandwidth(),"bandwidth");
        page = amplitudeDao.selectPage(page,queryWrapper);
        List<MicrowaveAmplitudeItemDto> rows = new ArrayList<>();
        if(ObjectUtils.isNotNull(page.getRecords())){
            for(MicrowaveAmplitudeEntity entity:page.getRecords()){
                MicrowaveAmplitudeItemDto itemDto = new MicrowaveAmplitudeItemDto();
                BeanUtils.copyProperties(entity,itemDto);
                rows.add(itemDto);
            }
        }
        return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
    }

    @Override
    public MicrowaveAmplitudeInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.MICRO_AMPLITUDE);
        MicrowaveAmplitudeEntity entity = amplitudeDao.selectById(id);
        if(ObjectUtils.isNotNull(entity)){
            MicrowaveAmplitudeInfoDto infoDto = new MicrowaveAmplitudeInfoDto();
            BeanUtils.copyProperties(entity,infoDto);
            if(ObjectUtils.isNotNull(entity.getData())){
                String dataStr = baseBigdataRepositoryService.getDataFile(entity.getData());
                infoDto.setDataJson(dataStr);
            }
            return infoDto;
        }
        return null;
    }
}
