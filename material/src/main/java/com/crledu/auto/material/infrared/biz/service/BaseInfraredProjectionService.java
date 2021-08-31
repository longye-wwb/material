package com.crledu.auto.material.infrared.biz.service;

import com.crledu.auto.material.infrared.biz.dto.InfraredProjectionFormdataDto;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 红外反射微波透射层service
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 13:43
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredProjectionService {

    void importData(MultipartFile struct, InfraredProjectionFormdataDto formDataDto, Long creator, MultipartFile process, MultipartFile projection);

    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
