package com.crledu.auto.material.antenna.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.antenna.data.dto.AntennaMaterialInfoDto;
import com.crledu.auto.material.antenna.data.dto.AntennaMaterialItemDto;
import com.crledu.auto.material.antenna.data.dto.AntennaSelectParamDto;
import com.crledu.auto.material.antenna.data.service.BaseVisibleLightAntennaImportDataService;
import com.crledu.auto.material.antenna.repository.dao.BaseVisibleAntennaDao;
import com.crledu.auto.material.antenna.repository.entity.VisibleAntennaEntity;
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

/**
 ************************************************************
 * @Description: 可见光位相调控数据查询服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 16:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class VisibleLightAntennaImportDataServiceImpl extends AbstractAntennaDataService implements BaseVisibleLightAntennaImportDataService {

    @Resource
    private BaseVisibleAntennaDao dao;

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public PageDate<AntennaMaterialItemDto> selectPage(AntennaSelectParamDto selectParamDto) {
        counterService.addVisiter(DataTypeEnum.VISIBLE_LIGHT);
        QueryWrapper<VisibleAntennaEntity> queryWrapper = new QueryWrapper<>();
        buildQueryWrapper(queryWrapper,selectParamDto);
        Page<VisibleAntennaEntity> page = new Page<>(selectParamDto.getPageNum(),selectParamDto.getPageSize());
        page = dao.selectPage(page,queryWrapper);
        List<AntennaMaterialItemDto> rows = new ArrayList<>();
        if(ObjectUtils.isNotNull(page) && ObjectUtils.isNotNull(page.getRecords())){
            for(VisibleAntennaEntity entity:page.getRecords()){
                AntennaMaterialItemDto itemDto = new AntennaMaterialItemDto();
                BeanUtils.copyProperties(entity,itemDto);
                itemDto.setEff(entity.getEff());
                rows.add(itemDto);
            }
        }
        return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
    }

    @Override
    public AntennaMaterialInfoDto selectInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.VISIBLE_LIGHT);
        VisibleAntennaEntity entity = dao.selectById(id);
        if(ObjectUtils.isNotNull(entity)){
            AntennaMaterialInfoDto infoDto = new AntennaMaterialInfoDto();
            BeanUtils.copyProperties(entity,infoDto);
            infoDto.setEff(entity.getEff());
            String dataStr = bigdataRepositoryService.getDataFile(entity.getData());
            infoDto.setDataStr(dataStr);
            return infoDto;
        }
        return null;
    }
}
