package com.crledu.auto.material.impor.api.controller;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.impor.data.dto.ImportHistoryItemDto;
import com.crledu.auto.material.impor.data.dto.ImportHistorySelectDto;
import com.crledu.auto.material.impor.data.service.BaseImportHistoryDataService;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 ************************************************************
 * @Description: 导入历史查询
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 10:07
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "导入历史相关接口")
@RestController
@RequestMapping("history")
public class ImportHistoryController {

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseImportHistoryDataService importHistoryDataService;

    @ApiOperation("导入历史分页查询")
    @GetMapping("page")
    public Response<PageDate<ImportHistoryItemDto>> selectHisttory(ImportHistorySelectDto selectVo){
        return new Response<>().success(importHistoryDataService.selectPage(selectVo));
    }

    @ApiOperation("深度学习样本数据下载")
    @GetMapping("/data")
    public void downloadDataFile(Long id, HttpServletRequest request, HttpServletResponse response) throws IOException{
        downloadFile(request,response,baseBigdataRepositoryService.downloadData(id));
    }

    @ApiOperation("模拟程序下载")
    @GetMapping("/process")
    public void downloadProcess(Long id, HttpServletRequest request, HttpServletResponse response)throws IOException{
        downloadFile(request,response,importHistoryDataService.getProcess(id));
    }

    @ApiOperation("模拟程序文件空间占用")
    @GetMapping("/process_size")
    public Response<String> processFileSize(){
        return new Response<>().success(importHistoryDataService.ProcessFilesSize());
    }

    @ApiOperation("材料数据原文件空间占用")
    @GetMapping("/data_size")
    public Response<String> materialFileSize(){
        return new Response<>().success(importHistoryDataService.materialFilesSize());
    }

    @ApiOperation("材料数据导入总数")
    @GetMapping("/data_total")
    public Response<Integer> materialFileTotal(){
        return new Response<>().success(importHistoryDataService.countTotal());
    }


    private void downloadFile(HttpServletRequest request, HttpServletResponse response,File file) throws IOException{
        String userAgent = request.getHeader("User-Agent");
        OutputStream out = null;
        BufferedInputStream ins = null;
        try{
            out = response.getOutputStream();
            String fileName = FileUtils.getFileName(file);
            // 针对IE或者以IE为内核的浏览器：
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
            } else {
                // 非IE浏览器的处理：
                fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
            }
            response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
            response.addHeader("Content-Length", "" + file.length());
            response.setContentType("application/octet-stream");
            ins = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            while(ins.read(buffer)>0){
                out.write(buffer);
            }
            out.flush();
        }catch (IOException e){
            response.setContentType("application/json");
            out.write(JSON.toJSONString(new Response().failure("文件下载或者获取出错："+e.getMessage())).getBytes());
            return ;
        }finally {
            try{
                if(out != null){
                    out.close();
                }
                if(ins != null){
                    ins.close();
                }
            }catch (IOException e){
                response.setContentType("application/json");
                out.write(JSON.toJSONString(new Response().failure("文件资源流没有正常关闭。"+e.getMessage())).getBytes());
            }
        }
    }
}
