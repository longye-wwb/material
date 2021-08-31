package com.crledu.auto.material.second.biz.repository;

import com.crledu.auto.material.second.biz.domain.BoundaryDomain;

/**
 ************************************************************
 * @Description: 边界优化超透镜业务对象数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:51
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseBoundaryRepository {

    void saveInData(BoundaryDomain domain);
}
