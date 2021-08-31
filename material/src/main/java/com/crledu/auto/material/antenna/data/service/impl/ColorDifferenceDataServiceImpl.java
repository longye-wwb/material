package com.crledu.auto.material.antenna.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.antenna.data.dto.*;
import com.crledu.auto.material.antenna.data.service.BaseColorDifferenceDataService;
import com.crledu.auto.material.antenna.repository.dao.BaseColorDiffrenceMapper;
import com.crledu.auto.material.antenna.repository.entity.ColorDifferenceEntity;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ColorDifferenceDataServiceImpl  extends AbstractAntennaDataService implements BaseColorDifferenceDataService {

    @Resource
    private BaseColorDiffrenceMapper dao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<ColorDifferenceItemDto> selectPage(AntennaSelectParamDto selectParamDto) {
        counterService.addVisiter(DataTypeEnum.INFRARED_AMPLITUDE);
        QueryWrapper<ColorDifferenceEntity> queryWrapper = new QueryWrapper<>();//可以改一下名字ColorDiffence那
        buildQueryWrapper(queryWrapper,selectParamDto);
        Page<ColorDifferenceEntity> page = new Page<>(selectParamDto.getPageNum(),selectParamDto.getPageSize());//分页查询
        //上面是准备的
        //下面是弄数据库的
        page = dao.selectPage(page,queryWrapper);//查询条件，返回信息
        List<ColorDifferenceItemDto> rows = new ArrayList<>();
        //判断这些是否是空
        if(ObjectUtils.isNotNull(page) && ObjectUtils.isNotNull(page.getRecords())){
            for(ColorDifferenceEntity entity:page.getRecords()){//拿到列表去遍历
                ColorDifferenceItemDto itemDto = new ColorDifferenceItemDto();//改一下名字就行了
                BeanUtils.copyProperties(entity,itemDto);
                rows.add(itemDto);
            }
        }
        return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
    }

    @Override
    public ColorDifferenceInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.INFRARED_AMPLITUDE);
        ColorDifferenceEntity entity = dao.selectById(id);//通过id去查，dao
        if(ObjectUtils.isNotNull(entity)){
            ColorDifferenceInfoDto infoDto = new ColorDifferenceInfoDto();//数据传输方式是dto
            BeanUtils.copyProperties(entity,infoDto);
            String dataStr = bigdataRepositoryService.getDataFile(entity.getData());//如果有datastr这个需要加上
            infoDto.setDataStr(dataStr);
            return infoDto;
        }
        return null;
    }
}
