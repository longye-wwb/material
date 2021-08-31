package com.crledu.auto.material.second.data.service.impl;

import com.crledu.auto.material.second.data.dto.TopologyDataInfoDto;
import com.crledu.auto.material.second.data.dto.TopologyDataItemDto;
import com.crledu.auto.material.second.data.dto.TopologySelectParamVo;
import com.crledu.auto.material.second.data.service.BaseTopologyDataService;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Service;

@Service
public class TopologyDataServiceImpl implements BaseTopologyDataService {
    @Override
    public PageDate<TopologyDataItemDto> selectPage(TopologySelectParamVo paramVo) {
        return null;
    }

    @Override
    public TopologyDataInfoDto selectInfo(Long id) {
        return null;
    }
    //按照ColorDifferenceDataServiceImpl去写就对了
}
