package com.crledu.auto.material.breath.biz.repository;

import com.crledu.auto.material.breath.biz.domain.BreadthDomain;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface BreadthRepository {
    void saveIndata(BreadthDomain domain);
}
