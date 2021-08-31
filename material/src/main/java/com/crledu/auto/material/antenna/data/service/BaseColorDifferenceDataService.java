package com.crledu.auto.material.antenna.data.service;

import com.crledu.auto.material.antenna.data.dto.AntennaSelectParamDto;
import com.crledu.auto.material.antenna.data.dto.ColorDifferenceInfoDto;
import com.crledu.auto.material.antenna.data.dto.ColorDifferenceItemDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 消色差结构数据查询服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: \ 16:14
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseColorDifferenceDataService {

    PageDate<ColorDifferenceItemDto> selectPage(AntennaSelectParamDto selectParamDto);

    ColorDifferenceInfoDto selectInfo(Long id);
}
