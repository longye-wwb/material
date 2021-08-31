package com.crledu.auto.material.antenna.biz.service;

import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 消色差的导入服务接口定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 15:51
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseColorDifferenceService {

    void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
