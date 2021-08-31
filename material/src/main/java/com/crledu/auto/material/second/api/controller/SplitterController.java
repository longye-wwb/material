package com.crledu.auto.material.second.api.controller;

import com.crledu.auto.material.second.api.vo.SplitterCreateVo;
import com.crledu.auto.material.second.biz.dto.SplitterImportDto;
import com.crledu.auto.material.second.biz.service.BaseSplitterService;
import com.crledu.auto.material.second.data.dto.*;
import com.crledu.auto.material.second.data.service.BaseSplitterDataService;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 偏振分束功能波导
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 21:34
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "二期-偏振分束功能波导")
@RestController
@RequestMapping("splitter")
public class SplitterController extends AbstractController {

    @Resource
    private BaseSplitterService importService;

    @Resource
    private BaseSplitterDataService dataService;

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(SplitterCreateVo formVo, MultipartFile struct, MultipartFile te, MultipartFile tm, @RequestParam("process")MultipartFile process){
        SplitterImportDto formdataDto = new SplitterImportDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(true);
        importService.importData(formdataDto,loginUser().getId(),struct,te,tm,process);
        return new Response().success();
    }

    @ApiOperation("保存数据样本")
    @PostMapping("/save")
    public Response saveData(SplitterCreateVo formVo, MultipartFile struct, MultipartFile te, MultipartFile tm, MultipartFile process){
        SplitterImportDto formdataDto = new SplitterImportDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(false);
        importService.importData(formdataDto,loginUser().getId(),struct,te,tm,process);
        return new Response().success();
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Response<PageDate<SplitterDataItemDto>> selectPage(SplitterSelectParamVo paramDto){
        return new Response<>().success(dataService.selectPage(paramDto));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Response<SplitterDataInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }
}
