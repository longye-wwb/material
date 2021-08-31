package com.crledu.auto.material.microw.biz.service;

import com.crledu.auto.material.microw.biz.dto.MicrowavePhaseImportFormDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 微波宽带相位调控数据导入服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 17:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowavePhaseImportService {

    void importData(MicrowavePhaseImportFormDto formDto, Long creator, MultipartFile struct,MultipartFile range,MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
