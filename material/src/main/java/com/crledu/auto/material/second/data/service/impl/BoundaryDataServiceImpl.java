package com.crledu.auto.material.second.data.service.impl;

import com.crledu.auto.material.second.data.dto.BoundaryDataInfoDto;
import com.crledu.auto.material.second.data.dto.BoundaryDataItemDto;
import com.crledu.auto.material.second.data.dto.BoundarySelectParamVo;
import com.crledu.auto.material.second.data.service.BaseBoundaryDataService;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

@Service
public class BoundaryDataServiceImpl implements BaseBoundaryDataService {
    @Override
    public PageDate<BoundaryDataItemDto> selectPage(BoundarySelectParamVo paramVo) {
        return null;
    }

    @Override
    public BoundaryDataInfoDto selectInfo(Long id) {
        return null;
    }
}
