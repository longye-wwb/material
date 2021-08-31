package com.crledu.auto.material.microw.api.controller;

import com.crledu.auto.material.microw.api.vo.MicrowavePhaseImportFormVo;
import com.crledu.auto.material.microw.biz.dto.MicrowavePhaseImportFormDto;
import com.crledu.auto.material.microw.biz.service.BaseMicrowavePhaseImportService;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseItemDto;
import com.crledu.auto.material.microw.data.dto.MicrowavePhaseSelectParamDto;
import com.crledu.auto.material.microw.data.service.BaseMicrowavePhaseDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 微波宽带相位调控导入数据管理接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 10:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电-微波宽带相位调控导入数据管理接口")
@RestController
@RequestMapping("micro_phase")
public class MicrowavePhaseImportController extends AbstractController {

    @Resource
    private BaseMicrowavePhaseImportService importService;

    @Resource
    private BaseMicrowavePhaseDataService dataService;

    @ApiOperation("导入数据")
    @PostMapping("import")
    public Response importData(MicrowavePhaseImportFormVo importFormVo, MultipartFile struct,MultipartFile data,MultipartFile process){
        MicrowavePhaseImportFormDto formDto = new MicrowavePhaseImportFormDto();
        formDto.setLightAngle(importFormVo.getLightAngle());
        formDto.setThickness(importFormVo.getThickness());
        formDto.setWorkingMode(importFormVo.getWorkingMode());
        formDto.setDataFrom(importFormVo.getDataFrom());
        formDto.setLightType(importFormVo.getLightType());
        formDto.setSaveData(true);
        importService.importData(formDto,loginUser().getId(),struct,data,process);
        return new Response().success();
    }

    @ApiOperation("导入样本")
    @PostMapping("save")
    public Response saveData(MicrowavePhaseImportFormVo importFormVo, MultipartFile struct,MultipartFile data,MultipartFile process){
        MicrowavePhaseImportFormDto formDto = new MicrowavePhaseImportFormDto();
        formDto.setLightAngle(importFormVo.getLightAngle());
        formDto.setThickness(importFormVo.getThickness());
        formDto.setWorkingMode(importFormVo.getWorkingMode());
        formDto.setDataFrom(importFormVo.getDataFrom());
        formDto.setLightType(importFormVo.getLightType());
        formDto.setSaveData(false);
        importService.importData(formDto,loginUser().getId(),struct,data,process);
        return new Response().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        importService.buildImportTemplate(response,request);
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Response<PageDate<MicrowavePhaseItemDto>> selectPage(MicrowavePhaseSelectParamDto selectParamDto){
        return new Response<>().success(dataService.selectPage(selectParamDto));
    }

    @ApiOperation("详情查询")
    @GetMapping("/info")
    public Response<MicrowavePhaseInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }

}
