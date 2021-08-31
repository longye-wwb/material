package com.crledu.auto.material.cstparse.api.controller;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.cstparse.biz.service.BaseCsttxtFileService;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 ************************************************************
 * @Description: 文件转换工具方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 15:46
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "文件转换相关接口")
@RestController
@RequestMapping("conversion")
public class FileConversionController {

    @Resource
    private BaseCsttxtFileService csttxtFileService;

    @ApiOperation("将cst模拟产生的txt转换为csv文件")
    @PostMapping("to_csv")
    public void csttextToCsv(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userAgent = request.getHeader("User-Agent");
        csttxtFileService.decodeCsttxtFile(file,request,response);
    }
}
