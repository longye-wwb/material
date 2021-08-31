package com.crledu.auto.material.cooling.api.controller;

import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.material.cooling.api.vo.CoolingMaterailImportVo;
import com.crledu.auto.material.cooling.api.vo.CoolingMaterialSelectVo;
import com.crledu.auto.material.cooling.biz.dto.*;
import com.crledu.auto.material.cooling.biz.service.BaseCoolingMaterailService;
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
 * @Description: 辐射制冷相关接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 9:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电-辐射制冷材料数据库")
@RestController
@RequestMapping("meta_cooling")
public class CoolingMaterailController extends AbstractController {

    @Resource
    private BaseCoolingMaterailService coolingMaterailService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    private Response importData(CoolingMaterailImportVo importData, @RequestParam("struct") MultipartFile structFile, @RequestParam("data") MultipartFile dataFile, @RequestParam("process") MultipartFile processFile){
        CoolingMetatailImportDto materialImportDto = new CoolingMetatailImportDto();
        materialImportDto.setAbs(dataFile);
        materialImportDto.setBottomMaterail(importData.getBase().getMaterial());
        materialImportDto.setCreator(this.loginUser().getId());
        materialImportDto.setDataFrom(importData.getDataFrom());
        materialImportDto.setFirstMaterail(importData.getFirstMaterial());
        materialImportDto.setLayers(structFile);
        materialImportDto.setLightAngle(importData.getLightAngle());
        materialImportDto.setLightType(importData.getLightType());
        materialImportDto.setProcess(processFile);
        materialImportDto.setSecondMetarail(importData.getSecondMaterial());
        materialImportDto.setType(importData.getType());
        materialImportDto.setSaveData(true);
        materialImportDto.setWorkingMode(importData.getWorkMode());
        coolingMaterailService.importCoolingMaterialData(materialImportDto);
        return new Response().success();
    }

    @ApiOperation("导入数据样本")
    @PostMapping("/save")
    private Response saveData(CoolingMaterailImportVo importData, @RequestParam("struct") MultipartFile structFile, @RequestParam("data") MultipartFile dataFile, @RequestParam("process") MultipartFile processFile){
        CoolingMetatailImportDto materialImportDto = new CoolingMetatailImportDto();
        materialImportDto.setAbs(dataFile);
        materialImportDto.setBottomMaterail(importData.getBase().getMaterial());
        materialImportDto.setCreator(this.loginUser().getId());
        materialImportDto.setDataFrom(importData.getDataFrom());
        materialImportDto.setFirstMaterail(importData.getFirstMaterial());
        materialImportDto.setLayers(structFile);
        materialImportDto.setLightAngle(importData.getLightAngle());
        materialImportDto.setLightType(importData.getLightType());
        materialImportDto.setProcess(processFile);
        materialImportDto.setSecondMetarail(importData.getSecondMaterial());
        materialImportDto.setType(importData.getType());
        materialImportDto.setSaveData(false);
        materialImportDto.setWorkingMode(importData.getWorkMode());
        coolingMaterailService.importCoolingMaterialData(materialImportDto);
        return new Response().success();
    }

//    @GetMapping("/template")
//    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        coolingMaterailService.buildImportTemplate(response,request);
//    }

    @ApiOperation("分页获取材料列表")
    @GetMapping("page")
    public Response<PageDate<CoolingMaterialItemDto>> selectStructData(CoolingMaterialSelectVo selectVo)
    {
        CoolingMaterialSelectDto selectDto = new CoolingMaterialSelectDto();
        selectDto.setBaseMaterial(selectVo.getBaseMaterial());
        selectDto.setDataFrom(selectVo.getDataFrom());
        selectDto.setFirstMaterial(selectVo.getFirstMaterial());
        selectDto.setLayers(selectVo.getLayers());
        selectDto.setLightAngle(selectVo.getLightAngle());
        selectDto.setLightType(selectVo.getLightType());
        selectDto.setSecondMaterial(selectVo.getSecondMaterial());
        selectDto.setThickness(selectVo.getThickness());
        selectDto.setType(selectVo.getType());
        selectDto.setWorkingMode(selectVo.getWorkingMode());
        selectDto.setPageNum(selectVo.getPageNum());
        selectDto.setPageSize(selectVo.getPageSize());
        return new Response().success(coolingMaterailService.selectCoolingMaterial(selectDto));
    }

    @ApiOperation("获取材料详情")
    @GetMapping("info")
    public Response<CoolingMaterialInfoDto> selectCollMaterialIfo(Long id)
    {
        CoolingMaterialAbsorSelectDto selectDto = new CoolingMaterialAbsorSelectDto();
        selectDto.setId(id);
        return new Response().success(coolingMaterailService.findCoolingMaterialInfo(selectDto));
    }
}
