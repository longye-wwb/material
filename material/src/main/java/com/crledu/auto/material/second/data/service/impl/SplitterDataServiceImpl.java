package com.crledu.auto.material.second.data.service.impl;

import com.crledu.auto.material.second.data.dto.SplitterDataInfoDto;
import com.crledu.auto.material.second.data.dto.SplitterDataItemDto;
import com.crledu.auto.material.second.data.dto.SplitterSelectParamVo;
import com.crledu.auto.material.second.data.service.BaseSplitterDataService;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

@Service
public class SplitterDataServiceImpl implements BaseSplitterDataService {
    @Override
    public PageDate<SplitterDataItemDto> selectPage(SplitterSelectParamVo paramVo) {
        return null;
    }

    @Override
    public SplitterDataInfoDto selectInfo(Long id) {
        return null;
    }
}
