package com.crledu.auto.material.second.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.second.data.dto.DiffractionDataInfoDto;
import com.crledu.auto.material.second.data.dto.DiffractionDataItemDto;
import com.crledu.auto.material.second.data.dto.DiffractionSelectParamVo;
import com.crledu.auto.material.second.data.service.BaseDiffractionDataService;
import com.crledu.auto.material.second.repository.dao.BaseDiffractionMapper;
import com.crledu.auto.material.second.repository.entity.DiffractionEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 衍射组件数据查询服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:44
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class DiffractionDataServiceImpl implements BaseDiffractionDataService {

    @Resource
    private BaseDiffractionMapper mapper;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<DiffractionDataItemDto> selectPage(DiffractionSelectParamVo paramVo) {
        counterService.addVisiter(DataTypeEnum.DIFFRACTION);
        Page<DiffractionEntity> page = new Page<>(paramVo.getPageNum(),paramVo.getPageSize());
        QueryWrapper<DiffractionEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getAngle(),"angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getBaseRefractive(),"base_refractive");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getInLine(),"in_line");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getOrder(),"order");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getPeriod(),"period");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getRefractive(),"refractive");
        page = mapper.selectPage(page,queryWrapper);
        if(ObjectUtils.isNotNull(page.getRecords())){
            List<DiffractionDataItemDto> records = new ArrayList<>();
            for(DiffractionEntity entity:page.getRecords()){
                DiffractionDataItemDto diffractionDataItemDto = new DiffractionDataItemDto();
                diffractionDataItemDto.setAngle(entity.getAngle());
                diffractionDataItemDto.setBaseRefractive(entity.getBaseRefractive());
                diffractionDataItemDto.setCurStatus(entity.getCurStatus());
                diffractionDataItemDto.setId(entity.getId());
                diffractionDataItemDto.setInLine(entity.getInLine());
                diffractionDataItemDto.setOrder(entity.getOrder1());
                diffractionDataItemDto.setPeriod(entity.getPeriod());
                diffractionDataItemDto.setRefractive(entity.getRefractive());
                records.add(diffractionDataItemDto);
            }
            PageDate<DiffractionDataItemDto> result = new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),records);
            return result;
        }else {
            return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),new ArrayList<>());
        }
    }

    @Override
    public DiffractionDataInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.INFRARED_GRATING);
        DiffractionEntity entity = mapper.selectById(id);
        DiffractionDataInfoDto diffractionDataItemDto = new DiffractionDataInfoDto();
        diffractionDataItemDto.setAngle(entity.getAngle());
        diffractionDataItemDto.setBaseRefractive(entity.getBaseRefractive());
        diffractionDataItemDto.setCurStatus(entity.getCurStatus());
        diffractionDataItemDto.setId(entity.getId());
        diffractionDataItemDto.setInLine(entity.getInLine());
        diffractionDataItemDto.setOrder(entity.getOrder1());
        diffractionDataItemDto.setPeriod(entity.getPeriod());
        diffractionDataItemDto.setRefractive(entity.getRefractive());
        String dataFile = baseBigdataRepositoryService.getDataFile(entity.getDataStr());
        diffractionDataItemDto.setData(dataFile);
        diffractionDataItemDto.setDiffraction(entity.getDiffraction());
        diffractionDataItemDto.setPicture(entity.getPicture());
        return diffractionDataItemDto;
    }

    @Override
    public File getPicture(Long id) {
        DiffractionEntity entity = mapper.selectById(id);
        if(ObjectUtils.isNotNull(entity)){
            return new File(entity.getPicture());
        }else{
            return null;
        }
    }
}
