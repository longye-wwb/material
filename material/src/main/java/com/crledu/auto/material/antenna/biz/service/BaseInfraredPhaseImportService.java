package com.crledu.auto.material.antenna.biz.service;

import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description:
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 9:23
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredPhaseImportService {
    void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
