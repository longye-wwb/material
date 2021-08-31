package com.crledu.auto.material.grating.biz.service;

import com.crledu.auto.material.grating.biz.dto.InfraredGratingFormDataDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 红外光栅数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 18:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredGratingService {

    void importData(MultipartFile struct, InfraredGratingFormDataDto formDataDto,Long creator,MultipartFile process,MultipartFile absorbing);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;

}
