package com.crledu.auto.material.infrared.data.service;

import com.crledu.auto.material.infrared.data.dto.InfraredProjectionInfoDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionItemDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionSelectParamDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 红外反射微波透射数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 18:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredProjectionDataService {

    PageDate<InfraredProjectionItemDto> selectPage(InfraredProjectionSelectParamDto selectParam);

    InfraredProjectionInfoDto findInfo(Long id);
}
