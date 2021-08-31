package com.crledu.auto.material.option.biz.service;

/**
 ************************************************************
 * @Description: 下拉选参数类型相关数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 11:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseOptionTypeSevice {

    void crateOptionType(String code,String name);
    void addOptionInType(Long type,String code,String name);
}
