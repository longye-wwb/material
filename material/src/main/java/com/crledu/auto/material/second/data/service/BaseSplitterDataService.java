package com.crledu.auto.material.second.data.service;

import com.crledu.auto.material.second.data.dto.*;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 偏振分束功能波导
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 21:41
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseSplitterDataService {

    PageDate<SplitterDataItemDto> selectPage(SplitterSelectParamVo paramVo);

    SplitterDataInfoDto selectInfo(Long id);
}
