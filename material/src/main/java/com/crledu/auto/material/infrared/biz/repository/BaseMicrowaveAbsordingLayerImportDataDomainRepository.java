package com.crledu.auto.material.infrared.biz.repository;

import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingVo;
import com.crledu.auto.material.infrared.biz.domain.MicrowaveAbsordingLayerImportDataDomain;
import com.crledu.auto.material.infrared.biz.dto.MicrowaveAbsorbingSelectDto;
import com.crledu.auto.web.repository.BaseRepository;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 微波吸收层导入数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 17:05
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowaveAbsordingLayerImportDataDomainRepository extends BaseRepository<MicrowaveAbsordingLayerImportDataDomain> {
    PageDate<MicrowaveAbsorbingVo> selectAbsorbingList(MicrowaveAbsorbingSelectDto selectDto);

    MicrowaveAbsorbingVo selectInfo(Long id);

    void emptyTable();
}
