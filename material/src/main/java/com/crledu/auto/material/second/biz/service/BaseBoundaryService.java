package com.crledu.auto.material.second.biz.service;

import com.crledu.auto.material.second.biz.dto.BoundaryImportDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 边界优化超透镜导入数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseBoundaryService {

    void importData(BoundaryImportDto importDto, Long id, MultipartFile struct,MultipartFile real, MultipartFile empty, MultipartFile process);
    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;
}
