package com.crledu.auto.material.photon.biz.serviceImpl;

import com.crledu.auto.material.photon.biz.service.SequenceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/18
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Service
public class SequenceServiceImpl implements SequenceService {

    @Override
    public List<Long> getSequenceId(Integer num) {
        return null;
    }
}
