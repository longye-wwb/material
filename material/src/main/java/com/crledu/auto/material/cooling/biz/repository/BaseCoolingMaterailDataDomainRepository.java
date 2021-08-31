package com.crledu.auto.material.cooling.biz.repository;

import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailDataDomain;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialAbsorSelectDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialInfoDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialItemDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialSelectDto;
import com.crledu.auto.web.repository.BaseRepository;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 辐射制冷业务对象数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/20 14:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseCoolingMaterailDataDomainRepository extends BaseRepository<CoolingMaterailDataDomain> {

    PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto);

    CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto);
}
