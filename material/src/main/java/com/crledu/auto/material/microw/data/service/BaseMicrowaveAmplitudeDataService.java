package com.crledu.auto.material.microw.data.service;

import com.crledu.auto.material.microw.data.dto.MicrowAmplitudeSelectParamDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeItemDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 微波宽带振幅转换查询服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:21
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowaveAmplitudeDataService {

    PageDate<MicrowaveAmplitudeItemDto> selectPage(MicrowAmplitudeSelectParamDto selectParamDto);
    MicrowaveAmplitudeInfoDto selectInfo(Long id);
}
