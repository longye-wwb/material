package com.crledu.auto.material.second.biz.repository;

import com.crledu.auto.material.second.biz.domain.DiffractionDomian;

/**
 ************************************************************
 * @Description: 衍射组件导入数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/13 10:09
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseDiffractionRepository {

    void saveInData(DiffractionDomian domain);
}
