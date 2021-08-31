package com.crledu.auto.material.antenna.data.service;

import com.crledu.auto.material.antenna.data.dto.AntennaMaterialInfoDto;
import com.crledu.auto.material.antenna.data.dto.AntennaMaterialItemDto;
import com.crledu.auto.material.antenna.data.dto.AntennaSelectParamDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 可见光位相调控数据查询
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 16:51
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseVisibleLightAntennaImportDataService {

    PageDate<AntennaMaterialItemDto> selectPage(AntennaSelectParamDto selectParamDto);

    AntennaMaterialInfoDto selectInfo(Long id);
}
