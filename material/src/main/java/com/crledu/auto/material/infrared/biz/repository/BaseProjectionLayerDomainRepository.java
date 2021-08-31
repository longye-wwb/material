package com.crledu.auto.material.infrared.biz.repository;

import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.domain.ProjectionLayerDomain;
import com.crledu.auto.material.infrared.biz.dto.ProjectionLayerImportDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionSelectDto;
import com.crledu.auto.web.repository.BaseRepository;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 微波透射层材料业务仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/23 17:36
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseProjectionLayerDomainRepository extends BaseRepository<ProjectionLayerDomain> {
    PageDate<ProjectionVo> selectProjectionList(ProjectionSelectDto projectionSelectDto);

    ProjectionVo selectInfo(Long id);

    void emptyTable();
}
