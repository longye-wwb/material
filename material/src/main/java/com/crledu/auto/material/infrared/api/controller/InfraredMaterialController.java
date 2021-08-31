package com.crledu.auto.material.infrared.api.controller;

import com.crledu.auto.material.infrared.api.vo.*;
import com.crledu.auto.material.infrared.biz.dto.*;
import com.crledu.auto.material.infrared.biz.service.BaseInfraredMaterialService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 微波红外兼容接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:12
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电-微波红外兼容")
@RestController
@RequestMapping("infrared")
public class InfraredMaterialController extends AbstractController {

    @Resource
    private BaseInfraredMaterialService infraredMaterialService;

    @ApiOperation("透射率数据导入")
    @PostMapping("/projection")
    public Response uploadProjectionLayerData(ProjectionLayerImportVo importVo, MultipartFile struct, MultipartFile data, MultipartFile process){
        ProjectionLayerImportDto importDto = new ProjectionLayerImportDto();
        importDto.setBaseDielectric(importVo.getBaseDielectric());
        importDto.setBaseEmissivity(importVo.getBaseEmissivity());
        importDto.setBaseMaterial(importVo.getBaseMaterial());
        importDto.setData(data);
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setDielectricConstant(importVo.getDielectricConstant());
        importDto.setDielectricEmissivity(importVo.getDielectricEmissivity());
        importDto.setDielectricMaterial(importVo.getDielectricMaterial());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setPatchEmissivity(importVo.getPatchEmissivity());
        importDto.setPatchMaterial(importVo.getPatchMaterial());
        importDto.setStruct(struct);
        importDto.setCreator(loginUser().getId());
        importDto.setSaveData(true);
        infraredMaterialService.saveProjectionData(importDto);
        return new Response().success();
    }

    @ApiOperation("透射率数据导入")
    @PostMapping("/projection_save")
    public Response saveProjectionLayerData(ProjectionLayerImportVo importVo, MultipartFile struct, MultipartFile data, MultipartFile process){
        ProjectionLayerImportDto importDto = new ProjectionLayerImportDto();
        importDto.setBaseDielectric(importVo.getBaseDielectric());
        importDto.setBaseEmissivity(importVo.getBaseEmissivity());
        importDto.setBaseMaterial(importVo.getBaseMaterial());
        importDto.setData(data);
        importDto.setDataFrom(importVo.getDataFrom());
        importDto.setDielectricConstant(importVo.getDielectricConstant());
        importDto.setDielectricEmissivity(importVo.getDielectricEmissivity());
        importDto.setDielectricMaterial(importVo.getDielectricMaterial());
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setPatchEmissivity(importVo.getPatchEmissivity());
        importDto.setPatchMaterial(importVo.getPatchMaterial());
        importDto.setStruct(struct);
        importDto.setCreator(loginUser().getId());
        importDto.setSaveData(false);
        infraredMaterialService.saveProjectionData(importDto);
        return new Response().success();
    }

    @ApiOperation("吸收率数据导入")
    @PostMapping("/absorbing")
    public Response uploadMicrowaveAbsorbingLayerData(MicrowaveAbsorbingLayerImportVo importVo, MultipartFile struct, MultipartFile data, MultipartFile process){
        MicrowaveAbsorbingLayerImportDto importDto = new MicrowaveAbsorbingLayerImportDto();
        importDto.setCreator(loginUser().getId());
        importDto.setData(data);
        importDto.setDataFrom(importVo.getDataFrom());
        if(importVo.getLayerItemVos()!=null&&importVo.getLayerItemVos().size()>0){
            List<MicrowaveAbsorbingItemLayerDto> layers = new ArrayList<>();
            for(LayerItemVo itemVo : importVo.getLayerItemVos()){
                MicrowaveAbsorbingItemLayerDto itemLayerDto = new MicrowaveAbsorbingItemLayerDto();
                itemLayerDto.setBaseDielectricConstant(itemVo.getBaseDielectricConstant());
                itemLayerDto.setBaseMaterial(itemVo.getBaseMaterial());
                itemLayerDto.setDielectricConstant(itemVo.getDielectricConstant());
                itemLayerDto.setDielectricMaterial(itemVo.getDielectricMaterial());
                itemLayerDto.setShape(itemVo.getShape());
                layers.add(itemLayerDto);
            }
            importDto.setLayerItemVos(layers);
        }else{
            throw new RestRuntimeException("1000000201","微波吸收功能层促成层参数缺失");
        }
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setPeriod(importVo.getPeriod());
        importDto.setProcess(process);
        importDto.setStruct(struct);
        importDto.setSaveInData(true);
        infraredMaterialService.saveMicrowaveAbsorbingData(importDto);
        return new Response().success();
    }

    @ApiOperation("吸收率数据导入")
    @PostMapping("/absorbing_save")
    public Response saveMicrowaveAbsorbingLayerData(MicrowaveAbsorbingLayerImportVo importVo, MultipartFile struct, MultipartFile data, MultipartFile process){
        MicrowaveAbsorbingLayerImportDto importDto = new MicrowaveAbsorbingLayerImportDto();
        importDto.setCreator(loginUser().getId());
        importDto.setData(data);
        importDto.setDataFrom(importVo.getDataFrom());
        if(importVo.getLayerItemVos()!=null&&importVo.getLayerItemVos().size()>0){
            List<MicrowaveAbsorbingItemLayerDto> layers = new ArrayList<>();
            for(LayerItemVo itemVo : importVo.getLayerItemVos()){
                MicrowaveAbsorbingItemLayerDto itemLayerDto = new MicrowaveAbsorbingItemLayerDto();
                itemLayerDto.setBaseDielectricConstant(itemVo.getBaseDielectricConstant());
                itemLayerDto.setBaseMaterial(itemVo.getBaseMaterial());
                itemLayerDto.setDielectricConstant(itemVo.getDielectricConstant());
                itemLayerDto.setDielectricMaterial(itemVo.getDielectricMaterial());
                itemLayerDto.setShape(itemVo.getShape());
                layers.add(itemLayerDto);
            }
            importDto.setLayerItemVos(layers);
        }else{
            throw new RestRuntimeException("1000000201","微波吸收功能层促成层参数缺失");
        }
        importDto.setLightAngle(importVo.getLightAngle());
        importDto.setPeriod(importVo.getPeriod());
        importDto.setProcess(process);
        importDto.setStruct(struct);
        importDto.setSaveInData(false);
        infraredMaterialService.saveMicrowaveAbsorbingData(importDto);
        return new Response().success();
    }

    @ApiOperation(value = "下载透射数据模板")
    @GetMapping("projection_temp")
    public void downloadProjection(HttpServletResponse response, HttpServletRequest request) throws IOException {
        infraredMaterialService.buildProjectionTemplateFile(response, request);
    }

    @ApiOperation(value = "下载吸收率数据模板")
    @GetMapping("absorbing_temp")
    public void downloadMicrowaveAbsorbing(HttpServletResponse response, HttpServletRequest request) throws IOException {
        infraredMaterialService.buildMicrowaveAbsorbingTemplateFile(response, request);
    }

    @ApiOperation(value ="查询透射率列表")
    @GetMapping("/ProjectionList")
    public Response<PageDate<ProjectionVo>> selectProjectionList(ProjectionSelectVo projectionSelectVo){
        ProjectionSelectDto selectDto = new ProjectionSelectDto();
        BeanUtils.copyProperties(projectionSelectVo,selectDto);
        PageDate<ProjectionVo> pageDate=infraredMaterialService.selectProjectionList(selectDto);
        return new Response<>().success(pageDate);
    }

    @ApiOperation(value ="查询透射率详情")
    @GetMapping("/ProjectionInfo")
    public Response<ProjectionVo> selectProjectionInfo(@RequestParam(name = "id")Long id){

        return new Response<>().success( infraredMaterialService.selectProjectionInfo(id));
    }


    @ApiOperation(value ="查询吸收率列表")
    @GetMapping("/MicrowaveList")
    public Response<PageDate<MicrowaveAbsorbingVo>> selectAbsorbingList(MicrowaveAbsorbingSelectVo selectVo){
        MicrowaveAbsorbingSelectDto selectDto = new MicrowaveAbsorbingSelectDto();
        BeanUtils.copyProperties(selectVo,selectDto);
        PageDate<MicrowaveAbsorbingVo> microwVo=infraredMaterialService.selectAbsorbingList(selectDto);
        return new Response<>().success(microwVo);
    }

    @ApiOperation(value ="查询吸收率详情")
    @GetMapping("/MicrowaveInfo")
    public Response<MicrowaveAbsorbingVo> selectAbsorbingInfo(@RequestParam(name = "id")Long id){
        MicrowaveAbsorbingVo microwaveAbsorbingVo = infraredMaterialService.selectAbsorbingInfo(id);
        return new Response<>().success(microwaveAbsorbingVo);
    }



}
