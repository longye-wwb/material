package com.crledu.auto.material.second.api.controller;

import com.crledu.auto.material.second.api.vo.TopologyCreateVo;
import com.crledu.auto.material.second.biz.dto.TopologyImportDto;
import com.crledu.auto.material.second.biz.service.BaseTopologyService;
import com.crledu.auto.material.second.data.dto.TopologyDataInfoDto;
import com.crledu.auto.material.second.data.dto.TopologyDataItemDto;
import com.crledu.auto.material.second.data.dto.TopologySelectParamVo;
import com.crledu.auto.material.second.data.service.BaseTopologyDataService;
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
 * @Description: 拓扑优化超透镜
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 17:38
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "二期-拓扑优化超透镜")
@RestController
@RequestMapping("topology")
public class TopologyController extends AbstractController {

    @Resource
    private BaseTopologyService importService;//导入服务--》biz

    @Resource
    private BaseTopologyDataService dataService;//数据服务--》data ctrl键访问

    @ApiOperation("导入数据")
    @PostMapping("/import")
    public Response importData(TopologyCreateVo formVo, MultipartFile geometry, MultipartFile ex, MultipartFile ey,MultipartFile ez, @RequestParam("process")MultipartFile process){
        TopologyImportDto formdataDto = new TopologyImportDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(true);
        importService.importData(formdataDto,loginUser().getId(),geometry,ex,ey,ez,process);
        return new Response().success();
    }

    @ApiOperation("保存数据样本")
    @PostMapping("/save")
    public Response saveData(TopologyCreateVo formVo, MultipartFile geometry, MultipartFile ex, MultipartFile ey,MultipartFile ez, MultipartFile process){
        TopologyImportDto formdataDto = new TopologyImportDto();
        BeanUtils.copyProperties(formVo,formdataDto);
        formdataDto.setSaveData(false);
        importService.importData(formdataDto,loginUser().getId(),geometry,ex,ey,ez,process);
        return new Response().success();
    }

//    //上面负责业务
//  这个需要更改其他的后端，修改根据前端以及其他文件
//    @GetMapping("/template")
//    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        importService.buildImportTemplate(response,request);
//    }
    //负责数据展示

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Response<PageDate<TopologyDataItemDto>> selectPage(TopologySelectParamVo paramDto){
        return new Response<>().success(dataService.selectPage(paramDto));
    }

    @ApiOperation("详情")
    @GetMapping("/info")
    public Response<TopologyDataInfoDto> selectInfo(Long id){
        return new Response<>().success(dataService.selectInfo(id));
    }
}
