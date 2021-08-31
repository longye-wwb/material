package com.crledu.auto.material.breath.api.controller;

import com.crledu.auto.material.breath.api.vo.BreadthImportVo;
import com.crledu.auto.material.breath.api.vo.BreadthInfoVo;
import com.crledu.auto.material.breath.api.vo.BreadthListVo;
import com.crledu.auto.material.breath.api.vo.BreadthSelectListVo;
import com.crledu.auto.material.breath.biz.dto.BreadthImpotDto;
import com.crledu.auto.material.breath.biz.service.BreadthService;
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
 * @Description: 宽窄
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Api(tags = "光电-微波窄带吸收")
@RestController
@RequestMapping("/breadth")
public class BreadthController extends AbstractController {

    @Autowired
    private BreadthService breadthService;


    @ApiOperation("导入宽窄数据")
    @PostMapping("import")
    public Response importBreadth(BreadthImportVo importVo, @RequestParam("structure")MultipartFile structure,@RequestParam("cruve")MultipartFile cruve,@RequestParam("process")MultipartFile process){
        BreadthImpotDto importDto = new BreadthImpotDto();
        importDto.setType(importVo.getType());
        importDto.setBaseMaterial(importVo.getBaseMaterial());
        importDto.setBaseThickness(importVo.getBaseThickness());
        importDto.setDielectric(importVo.getDielectric());
        importDto.setLoss(importVo.getLoss());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setStructureMaterial(importVo.getStructureMaterial());
        importDto.setStructureThickness(importVo.getStructureThickness());
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setMediumMaterial(importVo.getMediumMaterial());
        importDto.setLightType(importVo.getLightType());
        importDto.setSaveData(true);
        importDto.setWorkMode(importVo.getWorkMode());
        breadthService.importBreadth(importDto,loginUser().getId(),structure,cruve,process);
        return new Response().success();
    }

    @ApiOperation("导入宽窄数据")
    @PostMapping("save")
    public Response saveBreadth(BreadthImportVo importVo, @RequestParam("structure")MultipartFile structure,@RequestParam("cruve")MultipartFile cruve,@RequestParam("process")MultipartFile process){
        BreadthImpotDto importDto = new BreadthImpotDto();
        importDto.setType(importVo.getType());
        importDto.setBaseMaterial(importVo.getBaseMaterial());
        importDto.setBaseThickness(importVo.getBaseThickness());
        importDto.setDielectric(importVo.getDielectric());
        importDto.setLoss(importVo.getLoss());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setStructureMaterial(importVo.getStructureMaterial());
        importDto.setStructureThickness(importVo.getStructureThickness());
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setMediumMaterial(importVo.getMediumMaterial());
        importDto.setLightType(importVo.getLightType());
        importDto.setSaveData(false);
        importDto.setWorkMode(importVo.getWorkMode());
        breadthService.importBreadth(importDto,loginUser().getId(),structure,cruve,process);
        return new Response().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        breadthService.buildImportTemplate(response,request);
    }


    @ApiOperation("查询宽窄列表")
    @GetMapping("selectList")
    public Response<PageDate<BreadthListVo>> selectBreadthList(BreadthSelectListVo breadthSelectListVo){
        return new Response<>().success(breadthService.selectBreadthList(breadthSelectListVo));
    }

    @ApiOperation("查询宽窄详情")
    @GetMapping("selectInfo")
    public Response<BreadthInfoVo> selectBreadthInfo(@RequestParam(name = "id")Long id){

        return new Response().success(breadthService.selectBreadthInfo(id));
    }
}
