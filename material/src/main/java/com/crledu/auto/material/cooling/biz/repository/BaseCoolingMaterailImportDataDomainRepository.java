package com.crledu.auto.material.cooling.biz.repository;

import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailImportDataDomain;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialAbsorSelectDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialInfoDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialItemDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialSelectDto;
import com.crledu.auto.web.repository.BaseRepository;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 辐射制冷导入数据仓库接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/13 9:25
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseCoolingMaterailImportDataDomainRepository extends BaseRepository<CoolingMaterailImportDataDomain> {

    PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto);

    CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto);
}
