package com.crledu.auto.material.microwave.biz.service;

import com.crledu.auto.material.microwave.api.vo.MicrowaveInfoVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveListVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveSelectVo;
import com.crledu.auto.material.microwave.biz.dto.MicrowaveImportDto;
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
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface MicrowaveAbsorbService {
    void importMicrowave(MicrowaveImportDto importDto, Long id, MultipartFile structure, MultipartFile microwave, MultipartFile process);

    PageDate<MicrowaveListVo> selectMicrowave(MicrowaveSelectVo selectVo);

    MicrowaveInfoVo selectMicrowaveInfo(Long id);

    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
