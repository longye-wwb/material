package com.crledu.auto.material.grating.api.controller;

import com.crledu.auto.material.grating.api.vo.InfraredGratingImportVo;
import com.crledu.auto.material.grating.api.vo.InfraredGratingSelectParamVo;
import com.crledu.auto.material.grating.biz.dto.InfraredGratingFormDataDto;
import com.crledu.auto.material.grating.biz.service.BaseInfraredGratingService;
import com.crledu.auto.material.grating.data.dto.InfraredGratingInfoDto;
import com.crledu.auto.material.grating.data.dto.InfraredGratingItemDto;
import com.crledu.auto.material.grating.data.service.BaseInfraredGratingDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 红外光栅相关定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/2 13:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电_红外窄带传感相关接口")
@RestController
@RequestMapping("mate_grating")
public class InfraredGratingController extends AbstractController {

    @Resource
    private BaseInfraredGratingService service;

    @Resource
    private BaseInfraredGratingDataService infraredGratingDataService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(InfraredGratingImportVo importVo, @RequestParam("struct") MultipartFile structFile, @RequestParam("data") MultipartFile dataFile, @RequestParam("process") MultipartFile processFile){
        InfraredGratingFormDataDto formDataDto = new InfraredGratingFormDataDto();
        formDataDto.setLightAngle(importVo.getLightAngle());
        formDataDto.setDataFrom(importVo.getDataFrom());
        formDataDto.setMaterial(importVo.getMaterial());
        formDataDto.setLightType(importVo.getLightType());
        formDataDto.setSaveData(true);
        service.importData(structFile,formDataDto,loginUser().getId(),processFile,dataFile);
        return new Response().success();
    }

    @ApiOperation("导入样本")
    @PostMapping("/save")
    public Response saveData(InfraredGratingImportVo importVo, @RequestParam("struct") MultipartFile structFile, @RequestParam("data") MultipartFile dataFile, @RequestParam("process") MultipartFile processFile){
        InfraredGratingFormDataDto formDataDto = new InfraredGratingFormDataDto();
        formDataDto.setLightAngle(importVo.getLightAngle());
        formDataDto.setDataFrom(importVo.getDataFrom());
        formDataDto.setMaterial(importVo.getMaterial());
        formDataDto.setLightType(importVo.getLightType());
        formDataDto.setSaveData(false);
        service.importData(structFile,formDataDto,loginUser().getId(),processFile,dataFile);
        return new Response().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.buildImportTemplate(response,request);
    }

    @ApiOperation("分页筛选")
    @GetMapping("/page")
    public Response<PageDate<InfraredGratingItemDto>> selecteInfraredGratingMaterial(InfraredGratingSelectParamVo selectParamVo){
        return new Response().success(infraredGratingDataService.selectPage(selectParamVo));
    }

    @ApiOperation("查询材料详情")
    @GetMapping("/info")
    public Response<InfraredGratingInfoDto> selectInfraredGratingInfo(Long id){
        return new Response().success(infraredGratingDataService.selectInfo(id));
    }
}
