package com.crledu.auto.material.system.biz.domain;

/**
 ************************************************************
 * @Description: 数据文件容量计数器
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/3 15:28
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class BigdataFileSizeDomain extends BaseCounterDomain{

    public static final Long ID = 2L;


    public BigdataFileSizeDomain( Float total) {
        super(ID, total);
    }
}
