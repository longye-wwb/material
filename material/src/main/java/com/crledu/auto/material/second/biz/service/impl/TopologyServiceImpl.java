package com.crledu.auto.material.second.biz.service.impl;

import com.crledu.auto.material.second.biz.dto.TopologyImportDto;
import com.crledu.auto.material.second.biz.service.BaseTopologyService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 拓扑优化超透镜业务服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class TopologyServiceImpl implements BaseTopologyService {
    @Override
    public void importData(TopologyImportDto importDto, Long id, MultipartFile geometry, MultipartFile ex, MultipartFile ey, MultipartFile ez, MultipartFile process) {

    }
}
