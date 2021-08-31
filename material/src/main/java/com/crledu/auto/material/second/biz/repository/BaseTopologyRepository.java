package com.crledu.auto.material.second.biz.repository;

import com.crledu.auto.material.second.biz.domain.TopologyDomain;

/**
 ************************************************************
 * @Description: 拓扑优化超透镜业务对象数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseTopologyRepository {

    void saveInData(TopologyDomain domain);
}
