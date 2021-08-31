package com.crledu.auto.material.system.api.controller;

import com.crledu.auto.material.system.api.vo.DataVisitorCounterItemVo;
import com.crledu.auto.material.system.data.service.BaseVisitorCounterDataService;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 ************************************************************
 * @Description: 热度访问统计数据接口
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/2/20 15:16
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Api(tags = "热度访问统计数据接口")
@RestController
@RequestMapping("hots")
public class VisitorCounterController {

    @Resource
    private BaseVisitorCounterDataService dataService;

    @ApiOperation("总访问量")
    @GetMapping("/total")
    public Response<Float> total(){
        Float total = dataService.totalVisitor();
        return new Response<>().success(total);
    }

    @ApiOperation("数据热度")
    @GetMapping("/list")
    public Response<List<DataVisitorCounterItemVo>> typeTotal(){
        List<DataVisitorCounterItemVo> result = dataService.listVisitor();
        return new Response<>().success(result);
    }
}
