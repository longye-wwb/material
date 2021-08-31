package com.crledu.auto.material.microwaveIntegration.biz.service;

import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationInfoVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationListVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationSelectVo;
import com.crledu.auto.material.microwaveIntegration.biz.dto.MicrowaveIntegrationImportDto;
import com.crledu.auto.web.response.PageDate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface MicrowaveIntegrationService {
    void importIntegretion(MicrowaveIntegrationImportDto importDto, Long id, MultipartFile structure, MultipartFile broadband, MultipartFile narrowband, MultipartFile process);

    PageDate<MicrowaveIntegrationListVo> selectMicrowave(MicrowaveIntegrationSelectVo selectVo);

    MicrowaveIntegrationInfoVo selectMicrowaveInfo(Long id);

    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
