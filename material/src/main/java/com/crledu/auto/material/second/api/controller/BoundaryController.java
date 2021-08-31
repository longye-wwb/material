package com.crledu.auto.material.second.api.controller;

import com.crledu.auto.material.antenna.api.vo.AntennaImportFormVo;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.data.dto.AntennaSelectParamDto;
import com.crledu.auto.material.antenna.data.dto.ColorDifferenceInfoDto;
import com.crledu.auto.material.antenna.data.dto.ColorDifferenceItemDto;
import com.crledu.auto.material.second.api.vo.BoundaryCreateVo;
import com.crledu.auto.material.second.biz.dto.BoundaryImportDto;
import com.crledu.auto.material.second.biz.service.BaseBoundaryService;
import com.crledu.auto.material.second.data.dto.BoundaryDataInfoDto;
import com.crledu.auto.material.second.data.dto.BoundaryDataItemDto;
import com.crledu.auto.material.second.data.dto.BoundarySelectParamVo;
import com.crledu.auto.material.second.data.service.BaseBoundaryDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
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

/**
 ************************************************************
 * @Description: 边界优化超透镜接口定义
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 16:49
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "二期-边界优化超透镜")
@RestController
@RequestMapping("boundary")
public class BoundaryController extends AbstractController {

    @Resource
    private BaseBoundaryService importService;

    @Resource
    private BaseBoundaryDataService dataService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(BoundaryCreateVo formVo, @RequestParam("struct")MultipartFile struct, @RequestParam("real")MultipartFile real, @RequestParam("empty")MultipartFile empty,@RequestParam("process")MultipartFile process){
        BoundaryImportDto formdataDto = new BoundaryImportDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(true);
        importService.importData(formdataDto,loginUser().getId(),struct,real,empty,process);
        return new Response().success();
    }

    @ApiOperation("保存数据样本")
    @PostMapping("/save")
    public Response saveData(BoundaryCreateVo formVo, MultipartFile struct, MultipartFile real, MultipartFile empty, MultipartFile process){
        BoundaryImportDto formdataDto = new BoundaryImportDto();
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
    public Response<PageDate<BoundaryDataItemDto>> selectPage(BoundarySelectParamVo paramDto){
        return new Response<>().success(dataService.selectPage(paramDto));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Response<BoundaryDataInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }
}
