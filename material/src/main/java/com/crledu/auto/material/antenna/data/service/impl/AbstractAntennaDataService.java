package com.crledu.auto.material.antenna.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.antenna.data.dto.AntennaSelectParamDto;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.util.web.StringParamQueryWrapperUtils;

/**
 ************************************************************
 * @Description: 纳米天线检索条件基础方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 17:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbstractAntennaDataService {

    protected  void buildQueryWrapper(QueryWrapper queryWrapper, AntennaSelectParamDto selectParamDto){
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,selectParamDto.getMaterial(),"material");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,selectParamDto.getBaseMaterial(),"base_material");
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getType()),"type",selectParamDto.getType());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getBaseType()),"base_type",selectParamDto.getBaseType());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getDataFrom()),"data_from",selectParamDto.getDataFrom());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getLightType()),"light_type",selectParamDto.getLightType());
        queryWrapper.eq(ObjectUtils.isNotNull(selectParamDto.getWorkingMode()),"working_mode",selectParamDto.getWorkingMode());
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getBaseConstant(),"base_constant");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getBaseHeight(),"base_height");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getBaseSide(),"base_side");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getConstant(),"constant");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getHeight(),"height");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getLongAxis(),"long_axis");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getMinorAxis(),"minor_axis");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getRadius(),"radius");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,selectParamDto.getEff(),"eff");
    }
}
