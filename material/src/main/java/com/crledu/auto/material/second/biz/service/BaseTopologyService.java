package com.crledu.auto.material.second.biz.service;

import com.crledu.auto.material.second.biz.dto.TopologyImportDto;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 拓扑优化导入服务定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 20:48
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseTopologyService {
    void importData(TopologyImportDto importDto, Long id, MultipartFile geometry, MultipartFile ex, MultipartFile ey, MultipartFile ez, MultipartFile process);
}
