package com.crledu.auto.material.microw.api.controller;

import com.crledu.auto.material.microw.api.vo.MicrowaveAmplitudeImportFormVo;
import com.crledu.auto.material.microw.biz.dto.MicrowaveAmplitudeImportFormDto;
import com.crledu.auto.material.microw.biz.service.BaseMicrowaveAmplitudeImportService;
import com.crledu.auto.material.microw.data.dto.MicrowAmplitudeSelectParamDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeInfoDto;
import com.crledu.auto.material.microw.data.dto.MicrowaveAmplitudeItemDto;
import com.crledu.auto.material.microw.data.service.BaseMicrowaveAmplitudeDataService;
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
 * @Description: 微波宽带偏振转换 接口定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 15:16
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电-微波宽带偏振转换接口")
@RestController
@RequestMapping("micro_amplitude")
public class MicrowaveAmplitudeImportController extends AbstractController {

    @Resource
    private BaseMicrowaveAmplitudeImportService importService;

    @Resource
    private BaseMicrowaveAmplitudeDataService dataService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(MicrowaveAmplitudeImportFormVo formVo, MultipartFile struct,MultipartFile xphase,MultipartFile yphase,MultipartFile process){
        MicrowaveAmplitudeImportFormDto formDto = new MicrowaveAmplitudeImportFormDto();
        formDto.setLightAngle(formVo.getLightAngle());
        formDto.setWorkingMode(formVo.getWorkingMode());
        formDto.setDataFrom(formVo.getDataFrom());
        formDto.setAmplitudeType(formVo.getAmplitudeType());
        formDto.setSaveData(true);
        importService.importData(formDto,loginUser().getId(),struct,xphase,yphase,process);
        return new Response().success();
    }

    @ApiOperation("导入样本")
    @PostMapping("/save")
    public Response saveData(MicrowaveAmplitudeImportFormVo formVo, MultipartFile struct,MultipartFile xphase,MultipartFile yphase,MultipartFile process){
        MicrowaveAmplitudeImportFormDto formDto = new MicrowaveAmplitudeImportFormDto();
        formDto.setLightAngle(formVo.getLightAngle());
        formDto.setWorkingMode(formVo.getWorkingMode());
        formDto.setDataFrom(formVo.getDataFrom());
        formDto.setAmplitudeType(formVo.getAmplitudeType());
        formDto.setSaveData(false);
        importService.importData(formDto,loginUser().getId(),struct,xphase,yphase,process);
        return new Response().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        importService.buildImportTemplate(response,request);
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Response<PageDate<MicrowaveAmplitudeItemDto>> selectPage(MicrowAmplitudeSelectParamDto selectParamDto){
        return new Response<>().success(dataService.selectPage(selectParamDto));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Response<MicrowaveAmplitudeInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }
}
