package com.crledu.auto.material.bigdata.api.controller;

import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 ************************************************************
 * @Description: 大数据仓库文件下载接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 16:56
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "数据仓库对应数据下载接口")
@RestController
@RequestMapping("bigdata")
public class BigdataRepositoryController {

    @Resource
    private BaseBigdataRepositoryService bigdataRepositoryService;

    @ApiOperation("数据仓库对应数据样本下载")
    @GetMapping("download")
    public void downloadData(Long id, HttpServletRequest request, HttpServletResponse response){
        String userAgent = request.getHeader("User-Agent");
        File file1 = bigdataRepositoryService.downloadData(id);
        OutputStream out = null;
        BufferedInputStream ins = null;
        try{
            out = response.getOutputStream();
            String fileName = FileUtils.getFileName(file1);
            // 针对IE或者以IE为内核的浏览器：
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
            response.addHeader("Content-Length", "" + file1.length());
            response.setContentType("application/octet-stream");
            ins = new BufferedInputStream(new FileInputStream(file1));
            byte[] buffer = new byte[1024];
            while(ins.read(buffer)>0){
                out.write(buffer);
            }
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @ApiOperation("数据仓库对应数据样本的总存储大小")
    @GetMapping("size")
    public Response countDataFileSize(){
        String  size = bigdataRepositoryService.countDataDileSize();
        return new Response().success(size);
    }
}
