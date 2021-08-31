package com.crledu.auto.material.microwave.api.controller;

import com.crledu.auto.material.microwave.api.vo.MicrowaveImportVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveInfoVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveListVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveSelectVo;
import com.crledu.auto.material.microwave.biz.dto.MicrowaveImportDto;
import com.crledu.auto.material.microwave.biz.service.MicrowaveAbsorbService;
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
 * @Description: 微波宽带吸波器。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Api(tags = "光电-微波宽带吸波器")
@RestController
@RequestMapping(value = "microwave_absorbing")
public class MicrowaveAbsorbingController extends AbstractController {

    @Autowired
    private MicrowaveAbsorbService microwaveAbsorbService;

    @ApiOperation("导入宽窄数据")
    @PostMapping("import")
    public Response importMicrowave(MicrowaveImportVo importVo, @RequestParam("structure") MultipartFile structure, @RequestParam("microwave")MultipartFile microwave, @RequestParam("process")MultipartFile process){
        MicrowaveImportDto importDto = new MicrowaveImportDto();
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setFiller(importVo.getFiller());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setLightType(importVo.getLightType());
        importDto.setMaterialStructure(importVo.getMaterialStructure());
        importDto.setWorkType(importDto.getWorkType());
        importDto.setSaveData(true);
        microwaveAbsorbService.importMicrowave(importDto,loginUser().getId(),structure,microwave,process);
        return new Response().success();

    }

    @ApiOperation("导入宽窄样本")
    @PostMapping("save")
    public Response saveMicrowave(MicrowaveImportVo importVo, @RequestParam("structure") MultipartFile structure, @RequestParam("microwave")MultipartFile microwave, @RequestParam("process")MultipartFile process){
        MicrowaveImportDto importDto = new MicrowaveImportDto();
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setFiller(importVo.getFiller());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setLightType(importVo.getLightType());
        importDto.setMaterialStructure(importVo.getMaterialStructure());
        importDto.setWorkType(importDto.getWorkType());
        importDto.setSaveData(false);
        microwaveAbsorbService.importMicrowave(importDto,loginUser().getId(),structure,microwave,process);
        return new Response().success();

    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        microwaveAbsorbService.buildImportTemplate(response,request);
    }


    @ApiOperation("查询宽窄列表")
    @GetMapping("selectList")
    public Response<PageDate<MicrowaveListVo>> selectBreadthList(MicrowaveSelectVo selectVo){

        return new Response<>().success(microwaveAbsorbService.selectMicrowave(selectVo));
    }

    @ApiOperation("查询宽窄详情")
    @GetMapping("selectInfo")
    public Response<MicrowaveInfoVo> selectBreadthInfo(@RequestParam(name = "id")Long id){

        return new Response().success(microwaveAbsorbService.selectMicrowaveInfo(id));
    }
}
