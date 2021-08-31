package com.crledu.auto.material.impor.biz.repository;

import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.web.repository.BaseRepository;

/**
 ************************************************************
 * @Description: 导入数据记录仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:52
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseImportDataDomainRepository extends BaseRepository<ImportDataDomain> {

    void setTotal(Long id,Integer total);
}
