package com.crledu.auto.material.second.biz.repository;

import com.crledu.auto.material.second.biz.domain.SplitterDomain;

/**
 ************************************************************
 * @Description: 偏振分束功能波导业务对象仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseSplitterRepository {

    void saveInData(SplitterDomain domain);
}
