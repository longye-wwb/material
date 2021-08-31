package com.crledu.auto.material.system.repository.impl;

import com.crledu.auto.material.system.biz.domain.BaseCounterDomain;
import com.crledu.auto.material.system.biz.repository.BaseCounterDomainRepository;
import com.crledu.auto.material.system.repository.dao.VisitorCounterMapper;
import com.crledu.auto.material.system.repository.entity.VisitorCounterEntity;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 网站计数器数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/19 15:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class CounterDomainRepositoryImpl implements BaseCounterDomainRepository {

    @Resource
    private VisitorCounterMapper visitorCounterMapper;
    @Override
    public BaseCounterDomain createWithData(Long id)
    {
        VisitorCounterEntity visitorCounterEntity = visitorCounterMapper.selectById(id);
        if(ObjectUtils.isNotNull(visitorCounterEntity)){
            BaseCounterDomain domain = new BaseCounterDomain(visitorCounterEntity.getId(),visitorCounterEntity.getTotal());
            return domain;
        }else{
            return null;
        }
    }

    @Override
    public BaseCounterDomain saveInData(BaseCounterDomain domain) {
        VisitorCounterEntity visitorCounterEntity = new VisitorCounterEntity();
        visitorCounterEntity.setId(domain.getId());
        visitorCounterEntity.setTotal(domain.getTotal());
        visitorCounterMapper.insert(visitorCounterEntity);
        return createWithData(visitorCounterEntity.getId());
    }

    @Override
    public BaseCounterDomain updateToData(BaseCounterDomain domain)
    {
        VisitorCounterEntity visitorCounterEntity = visitorCounterMapper.selectById(domain.getId());
        if(ObjectUtils.isNotNull(visitorCounterEntity)){
            visitorCounterEntity.setTotal(domain.getTotal());
            visitorCounterMapper.updateById(visitorCounterEntity);
            return createWithData(visitorCounterEntity.getId());
        }else{
            return null;
        }
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }
}
