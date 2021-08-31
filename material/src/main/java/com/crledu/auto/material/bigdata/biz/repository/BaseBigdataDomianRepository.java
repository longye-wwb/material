package com.crledu.auto.material.bigdata.biz.repository;

import com.crledu.auto.material.bigdata.biz.domain.BigdataDomain;
import com.crledu.auto.web.repository.BaseRepository;

import java.io.File;

/**
 ************************************************************
 * @Description: 大数据仓库业务对象仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 14:19
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseBigdataDomianRepository extends BaseRepository<BigdataDomain> {

    File getGetDataPackage(Long id);

    long getDataFileSize();
}
