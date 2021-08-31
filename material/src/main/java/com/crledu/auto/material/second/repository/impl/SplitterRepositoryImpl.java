package com.crledu.auto.material.second.repository.impl;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.second.biz.domain.SplitterDomain;
import com.crledu.auto.material.second.biz.repository.BaseSplitterRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 偏振分束功能波导业务对象数据仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:52
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class SplitterRepositoryImpl implements BaseSplitterRepository {

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;
    @Override
    public void saveInData(SplitterDomain domain) {

    }
}
