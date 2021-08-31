package com.crledu.auto.material.second.biz.service;

import com.crledu.auto.material.second.biz.dto.SplitterImportDto;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 偏振分束功能波导导入服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 21:30
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseSplitterService {

    void importData(SplitterImportDto importDto, Long id, MultipartFile struct, MultipartFile te, MultipartFile tm, MultipartFile process);
}
