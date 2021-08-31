package com.crledu.auto.material.cstparse.biz.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 ************************************************************
 * @Description: cst导出txt文件转csv
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 11:44
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseCsttxtFileService {

    void decodeCsttxtFile(MultipartFile source, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
