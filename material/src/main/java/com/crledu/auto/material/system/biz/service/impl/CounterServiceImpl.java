package com.crledu.auto.material.system.biz.service.impl;

import com.crledu.auto.material.system.biz.domain.BaseCounterDomain;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.repository.BaseCounterDomainRepository;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 模块数据热度计数器
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/4 9:24
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class CounterServiceImpl implements BaseCounterService {

    @Resource
    private BaseCounterDomainRepository counterDomainRepository;

    @Override
    public void addVisiter(DataTypeEnum typeEnum) {
        BaseCounterDomain counterDomain = counterDomainRepository.createWithData(Integer.toUnsignedLong(typeEnum.getId()));
        if(ObjectUtils.isNull(counterDomain)){
            counterDomain = new BaseCounterDomain(Integer.toUnsignedLong(typeEnum.getId()),1f);
            counterDomainRepository.saveInData(counterDomain);
        }else{
            counterDomain.add(1f);
            counterDomainRepository.updateToData(counterDomain);
        }
    }
}
