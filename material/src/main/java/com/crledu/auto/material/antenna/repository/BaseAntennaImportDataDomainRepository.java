package com.crledu.auto.material.antenna.repository;

import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.web.repository.BaseRepository;

/**
 ************************************************************
 * @Description: 可见光相位调控业务对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 18:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseAntennaImportDataDomainRepository {

    AntennaImportDataDomain get(Long id);

    AntennaImportDataDomain save(AntennaImportDataDomain domian);
}
