package com.crledu.auto.material.antenna.biz.service;

import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 天线结构数据导入服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 10:33
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseVisibleLightAntennaImportService {
    void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile phase, MultipartFile amplitude, MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
