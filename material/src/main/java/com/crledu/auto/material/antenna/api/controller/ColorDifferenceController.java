package com.crledu.auto.material.antenna.api.controller;

import com.crledu.auto.material.antenna.api.vo.AntennaImportFormVo;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.biz.service.BaseColorDifferenceService;
import com.crledu.auto.material.antenna.data.dto.*;
import com.crledu.auto.material.antenna.data.service.BaseColorDifferenceDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
 * @Description: 消色差结构数据管理相关接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:04
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "二期-消色差结构")
@RestController
@RequestMapping("color_difference")
public class ColorDifferenceController extends AbstractController {

    @Resource
    private BaseColorDifferenceService importService;

    @Resource
    private BaseColorDifferenceDataService dataService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(AntennaImportFormVo formVo, MultipartFile struct, MultipartFile real, MultipartFile empty, MultipartFile process){
        AntennaImportFormdataDto formdataDto = new AntennaImportFormdataDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(true);
        importService.importData(formdataDto,loginUser().getId(),struct,real,empty,process);
        return new Response().success();
    }

    @ApiOperation("保存数据样本")
    @PostMapping("/save")
    public Response saveData(AntennaImportFormVo formVo, MultipartFile struct, MultipartFile real, MultipartFile empty, MultipartFile process){
        AntennaImportFormdataDto formdataDto = new AntennaImportFormdataDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(false);
        importService.importData(formdataDto,loginUser().getId(),struct,real,empty,process);
        return new Response().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        importService.buildImportTemplate(response,request);
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Response<PageDate<ColorDifferenceItemDto>> selectPage(AntennaSelectParamDto paramDto){
        return new Response<>().success(dataService.selectPage(paramDto));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Response<ColorDifferenceInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }
}
