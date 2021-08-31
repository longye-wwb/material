package com.crledu.auto.material.second.data.service;

import com.crledu.auto.material.second.data.dto.DiffractionDataInfoDto;
import com.crledu.auto.material.second.data.dto.DiffractionDataItemDto;
import com.crledu.auto.material.second.data.dto.DiffractionSelectParamVo;
import com.crledu.auto.web.response.PageDate;

import java.io.File;

/**
 ************************************************************
 * @Description: 衍射组件数据查询服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseDiffractionDataService {

    PageDate<DiffractionDataItemDto> selectPage(DiffractionSelectParamVo paramVo);

    DiffractionDataInfoDto selectInfo(Long id);

    File getPicture(Long id);
}
