package com.crledu.auto.material.microw.biz.service;

import com.crledu.auto.material.microw.biz.dto.MicrowaveAmplitudeImportFormDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 微波宽带偏振转换的服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 13:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowaveAmplitudeImportService {

    void importData(MicrowaveAmplitudeImportFormDto importFormDto, Long creator, MultipartFile struct,MultipartFile phaseX,MultipartFile phaseY,MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;

}
