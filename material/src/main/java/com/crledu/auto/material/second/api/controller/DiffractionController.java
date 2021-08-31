package com.crledu.auto.material.second.api.controller;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.material.second.api.vo.DiffractionCreateVo;
import com.crledu.auto.material.second.biz.dto.DiffractionImportDto;
import com.crledu.auto.material.second.biz.service.BaseDiffractionService;
import com.crledu.auto.material.second.data.dto.DiffractionDataInfoDto;
import com.crledu.auto.material.second.data.dto.DiffractionDataItemDto;
import com.crledu.auto.material.second.data.dto.DiffractionSelectParamVo;
import com.crledu.auto.material.second.data.service.BaseDiffractionDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 ************************************************************
 * @Description: 衍射组件相关接口定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/12 21:20
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "衍射组件数据")
@RestController
@RequestMapping("diffraction")
public class DiffractionController extends AbstractController {

    @Resource
    private BaseDiffractionService diffractionService;

    @Resource
    private BaseDiffractionDataService diffractionDataService;

    @PostMapping("import")
    @ApiOperation("导入数据")
    public Response importData(DiffractionCreateVo createVo , @RequestParam("structure") MultipartFile structure , @RequestParam("result") MultipartFile result ,@RequestParam("process")MultipartFile process){
        DiffractionImportDto dto = new DiffractionImportDto();
        dto.setAngle(createVo.getAngle());
        dto.setBaseRefractive(createVo.getBaseRefractive());
        dto.setInLine(createVo.getInLine());
        dto.setOrder(createVo.getOrder());
        dto.setPeriod(createVo.getPeriod());
        dto.setRefractive(createVo.getRefractive());
        dto.setDataFrom(createVo.getDataFrom());
        dto.setSaveData(true);
        diffractionService.importMicrowave(dto,loginUser().getId(),structure,result,process);
        return new Response().success();
    }

    @PostMapping("save")
    @ApiOperation("导入数据")
    public Response saveData(DiffractionCreateVo createVo , @RequestParam("structure") MultipartFile structure , @RequestParam("result") MultipartFile result ,@RequestParam("process")MultipartFile process){
        DiffractionImportDto dto = new DiffractionImportDto();
        dto.setAngle(createVo.getAngle());
        dto.setBaseRefractive(createVo.getBaseRefractive());
        dto.setInLine(createVo.getInLine());
        dto.setOrder(createVo.getOrder());
        dto.setPeriod(createVo.getPeriod());
        dto.setRefractive(createVo.getRefractive());
        dto.setDataFrom(createVo.getDataFrom());
        dto.setSaveData(false);
        diffractionService.importMicrowave(dto,loginUser().getId(),structure,result,process);
        return new Response().success();
    }

    @GetMapping("/page")
    @ApiOperation("分页检索")
    public Response<PageDate<DiffractionDataItemDto>> page(DiffractionSelectParamVo paramVo){
        PageDate<DiffractionDataItemDto> pageDate = diffractionDataService.selectPage(paramVo);
        return new Response<>().success(pageDate);
    }

    @GetMapping("/info")
    @ApiOperation("详情")
    public Response<DiffractionDataInfoDto> info(Long id){
        DiffractionDataInfoDto info = diffractionDataService.selectInfo(id);
        return new Response<>().success(info);
    }

    @ApiOperation("结构图片下载")
    @GetMapping("/picture")
    public void downloadProcess(Long id, HttpServletRequest request, HttpServletResponse response)throws IOException{
        downloadFile(request,response,diffractionDataService.getPicture(id));
    }


        private void downloadFile(HttpServletRequest request, HttpServletResponse response, File file) throws IOException {
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
