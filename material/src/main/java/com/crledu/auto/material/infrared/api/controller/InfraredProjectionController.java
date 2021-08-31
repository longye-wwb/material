package com.crledu.auto.material.infrared.api.controller;

import com.crledu.auto.material.infrared.api.vo.InfraredProjectionImportFormVo;
import com.crledu.auto.material.infrared.biz.dto.InfraredProjectionFormdataDto;
import com.crledu.auto.material.infrared.biz.service.BaseInfraredProjectionService;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionInfoDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionItemDto;
import com.crledu.auto.material.infrared.data.dto.InfraredProjectionSelectParamDto;
import com.crledu.auto.material.infrared.data.service.BaseInfraredProjectionDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
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
 * @Description: 红外宽带高反射及微波宽带高透射一体化材料相关接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/8 10:17
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "光电-红外宽带高反射及微波宽带高透射一体化")
@RestController
@RequestMapping("infrared_projection")
public class InfraredProjectionController extends AbstractController {

    @Resource
    private BaseInfraredProjectionService projectionService;

    @Resource
    private BaseInfraredProjectionDataService dataService;

    @PostMapping("/import")
    public Response importData(MultipartFile struct, MultipartFile data, MultipartFile process, InfraredProjectionImportFormVo formVo){
        InfraredProjectionFormdataDto formdataDto = new InfraredProjectionFormdataDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(true);
        projectionService.importData(struct,formdataDto,loginUser().getId(),process,data);
        return new Response<>().success();
    }

    @PostMapping("/save")
    public Response saveData(MultipartFile struct, MultipartFile data, MultipartFile process, InfraredProjectionImportFormVo formVo){
        InfraredProjectionFormdataDto formdataDto = new InfraredProjectionFormdataDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(false);
        projectionService.importData(struct,formdataDto,loginUser().getId(),process,data);
        return new Response<>().success();
    }

    @GetMapping("/template")
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        projectionService.buildImportTemplate(response,request);
    }

    @GetMapping("/page")
    public Response<PageDate<InfraredProjectionItemDto>> selectPage(InfraredProjectionSelectParamDto selectParamDto){
        return new Response<>().success(dataService.selectPage(selectParamDto));
    }

    @GetMapping("/info")
    public Response<InfraredProjectionInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.findInfo(id));
    }
}
