package com.crledu.auto.material.grating.data.service;

import com.crledu.auto.material.grating.api.vo.InfraredGratingSelectParamVo;
import com.crledu.auto.material.grating.data.dto.InfraredGratingInfoDto;
import com.crledu.auto.material.grating.data.dto.InfraredGratingItemDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 红外窄带传感查询service
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/4 17:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredGratingDataService {

    PageDate<InfraredGratingItemDto> selectPage(InfraredGratingSelectParamVo paramVo);

    InfraredGratingInfoDto selectInfo(Long id);

}
