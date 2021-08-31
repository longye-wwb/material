package com.crledu.auto.material.microwaveIntegration.api.controller;

import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationImportVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationInfoVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationListVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationSelectVo;
import com.crledu.auto.material.microwaveIntegration.biz.dto.MicrowaveIntegrationImportDto;
import com.crledu.auto.material.microwaveIntegration.biz.service.MicrowaveIntegrationService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ***********************************************************
 *
 * @Description: 微波一体化
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/


@Api(tags = "光电-微波窄带透波及宽带吸波一体化")
@RestController
@RequestMapping("/microwave_integration")
public class MicrowaveIntegrationController  extends AbstractController {

    @Autowired
    private MicrowaveIntegrationService integrationService;

    @ApiOperation("导入一体化数据")
    @PostMapping("/import")
    public Response importIntegration(MicrowaveIntegrationImportVo importVo, @RequestParam("structure") MultipartFile structure, @RequestParam("broadband")MultipartFile broadband, @RequestParam("narrowband")MultipartFile narrowband, @RequestParam("process")MultipartFile process){
        MicrowaveIntegrationImportDto importDto = new MicrowaveIntegrationImportDto();
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setDielectric(importVo.getDielectric());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setLightType(importVo.getLightType());
        importDto.setWorkType(importVo.getWorkType());
        importDto.setP(importVo.getP());
        importDto.setSaveData(true);
        integrationService.importIntegretion(importDto,loginUser().getId(),structure,broadband,narrowband,process);
        return new Response().success();

    }

    @ApiOperation("导入一体化样本")
    @PostMapping("/save")
    public Response saveIntegration(MicrowaveIntegrationImportVo importVo, @RequestParam("structure") MultipartFile structure, @RequestParam("broadband")MultipartFile broadband, @RequestParam("narrowband")MultipartFile narrowband, @RequestParam("process")MultipartFile process){
        MicrowaveIntegrationImportDto importDto = new MicrowaveIntegrationImportDto();
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setDielectric(importVo.getDielectric());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setLightType(importVo.getLightType());
        importDto.setWorkType(importVo.getWorkType());
        importDto.setP(importVo.getP());
        importDto.setSaveData(false);
        integrationService.importIntegretion(importDto,loginUser().getId(),structure,broadband,narrowband,process);
        return new Response().success();

    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        integrationService.buildImportTemplate(response,request);
    }


    @ApiOperation("查询宽窄列表")
    @GetMapping("/selectList")
    public Response<PageDate<MicrowaveIntegrationListVo>> selectBreadthList(MicrowaveIntegrationSelectVo selectVo){

        return new Response<>().success(integrationService.selectMicrowave(selectVo));
    }

    @ApiOperation("查询宽窄详情")
    @GetMapping("/selectInfo")
    public Response<MicrowaveIntegrationInfoVo> selectBreadthInfo(@RequestParam(name = "id")Long id){

        return new Response().success(integrationService.selectMicrowaveInfo(id));
    }

}
