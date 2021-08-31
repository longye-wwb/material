package com.crledu.auto.material.second.biz.service;

import com.crledu.auto.material.second.biz.dto.DiffractionImportDto;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 衍射组件数据保存服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 17:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseDiffractionService {

    void importMicrowave(DiffractionImportDto importDto, Long id, MultipartFile matFile,MultipartFile diffraction, MultipartFile process);
}
