package com.crledu.auto.material.microw.data.service;

import com.crledu.auto.material.microw.data.dto.MicrowavePhaseInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseItemDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseSelectParamDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 微波相位调控数据检索服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowavePhaseDataService {

    PageDate<MicrowavePhaseItemDto> selectPage(MicrowavePhaseSelectParamDto selectParamDto);
    MicrowavePhaseInfoDto selectInfo(Long id);
}
