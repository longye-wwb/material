package com.crledu.auto.material.second.data.service;

import com.crledu.auto.material.second.data.dto.*;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 边界优化超透镜数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 17:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseBoundaryDataService {

    PageDate<BoundaryDataItemDto> selectPage(BoundarySelectParamVo paramVo);

    BoundaryDataInfoDto selectInfo(Long id);
}
