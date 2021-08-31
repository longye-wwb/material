package com.crledu.auto.material.second.data.service;

import com.crledu.auto.material.second.data.dto.*;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 18:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseTopologyDataService {

    PageDate<TopologyDataItemDto> selectPage(TopologySelectParamVo paramVo);//分页查询展示的表

    TopologyDataInfoDto selectInfo(Long id);//详情
}
