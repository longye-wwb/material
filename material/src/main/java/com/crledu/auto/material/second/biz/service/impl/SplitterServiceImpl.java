package com.crledu.auto.material.second.biz.service.impl;

import com.crledu.auto.material.second.biz.dto.SplitterImportDto;
import com.crledu.auto.material.second.biz.service.BaseSplitterService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 ************************************************************
 * @Description: 偏振分束功能波导业务服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/18 10:56
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class SplitterServiceImpl implements BaseSplitterService {
    @Override
    public void importData(SplitterImportDto importDto, Long id, MultipartFile struct, MultipartFile te, MultipartFile tm, MultipartFile process) {

    }
}
