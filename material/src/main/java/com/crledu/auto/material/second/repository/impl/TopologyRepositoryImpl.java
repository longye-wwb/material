package com.crledu.auto.material.second.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.second.biz.domain.TopologyDomain;
import com.crledu.auto.material.second.biz.repository.BaseTopologyRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 拓扑优化超透镜业务对象数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class TopologyRepositoryImpl implements BaseTopologyRepository {

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @Override
    public void saveInData(TopologyDomain domain) {

    }
}
