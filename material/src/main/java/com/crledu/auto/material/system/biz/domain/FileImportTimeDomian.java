package com.crledu.auto.material.system.biz.domain;

/**
 ************************************************************
 * @Description: 导入数据次数计数器
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/3 15:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class FileImportTimeDomian extends BaseCounterDomain {

    public static final Long ID = 1L;

    public FileImportTimeDomian(Float total) {
        super(ID, total);
    }
}
