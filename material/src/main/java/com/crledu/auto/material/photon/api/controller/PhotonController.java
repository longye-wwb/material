package com.crledu.auto.material.photon.api.controller;

import com.alibaba.excel.EasyExcel;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.photon.repository.dto.PhotonExport;
import com.crledu.auto.material.photon.repository.dto.PhotonImport;
import com.crledu.auto.material.photon.repository.dto.PhotonModel;
import com.crledu.auto.material.photon.repository.dto.PhotonSelection;
import com.crledu.auto.material.photon.biz.service.PhotonService;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.system.dto.ViewUserDto;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Trevor
 * @Date: 2020/7/10 09:45
 * @Description: 光子
 */
@RestController
@RequestMapping("/photon")
@Api(tags = "光电-微波吸收材料")
public class PhotonController extends AbstractController {

    @Autowired
    private PhotonService photonService;

    @Resource
    private BaseCounterService counterService;

    /**
     *****************************************************************************
     * @Description 添加一个光子信息
     *****************************************************************************
     * @Param [photonImport]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 14:07
     *****************************************************************************
     **/
    @PostMapping("add")
    @ApiOperation(value = "录入一条新纪录")
    public Response addNewPhoton(@RequestBody PhotonImport photonImport){
        photonService.addNew(photonImport);
        return new Response().success();
    }


    /**
     *****************************************************************************
     * @Description 获得一个光子信息
     *****************************************************************************
     * @Param [id]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author zjs
     * @Date 2020/7/10 14:10
     *****************************************************************************
     **/
    @GetMapping("getInfo")
    @ApiOperation(value = "查看详情")
    public Response getInfo(@RequestParam(name = "id")Long id){

        counterService.addVisiter(DataTypeEnum.PHOTON);
        return new Response().success(photonService.getInfo(id));
    }


    /**
     ************************************************************
     * @Description:  获得光子信息列表
     * 错误返回编码。
     * @Version: v1.1.1
     ************************************************************
     * @CopyrightBy: 创享源信息技术有限公司
     * @author: zjs
     * @Date: 2020/7/10
     ************************************************************
     * @ModifiedBy: Trevor on 2020/7/10 14:13
     ************************************************************
     **/
    @GetMapping("getList")
    @ApiOperation(value = "获取信息列表")
    public Response<PageDate<Photon>> getList(@RequestParam(name = "pageNum")Integer current, @RequestParam(name = "pageSize")Integer size){

        counterService.addVisiter(DataTypeEnum.PHOTON);
        return new Response().success(photonService.getList(current,size));
    }


    /**
     *****************************************************************************
     * @Description excel 导入数据保存到数据库
     *****************************************************************************
     * @Param [file]
     * @return com.crledu.auto.web.response.Response
     *****************************************************************************
     * @Author zjs
     * @Date 2020/8/5 16:33
     *****************************************************************************
     **/
    @PostMapping("import")
    @ApiOperation(value = "批量导入")
    public  Response addFromFile(MultipartFile file,MultipartFile process){

        photonService.addFromFile(file,process,loginUser().getId());
        return new Response().success();
    }

    @PostMapping("save")
    @ApiOperation(value = "批量导入数据样本")
    public  Response saveFromFile(MultipartFile file,MultipartFile process){
        photonService.saveFromFile(file,process,loginUser().getId());
        return new Response().success();
    }


    /**
     *****************************************************************************
     * @Description  批量导出数据为excel
     *****************************************************************************
     * @Param [photonSelection, response]
     * @return void
     *****************************************************************************
     * @Author zjs
     * @Date 2020/8/5 16:38
     *****************************************************************************
     **/
    @PostMapping("export")
    @ApiOperation(value = "批量导出")
    public void dbToExcel(@RequestBody PhotonSelection photonSelection, HttpServletResponse response) throws IOException {
        counterService.addVisiter(DataTypeEnum.PHOTON);
        Date date = new Date();
        String fileName = date.getTime()+ ".csv";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03版本的excel 则 传入excelType参数即可xlsx改成xls
        // 参数一：写入excel文件路径
        // 参数二：写入的数据类型是TbDemo
        //data()方法是写入的数据，结果是List<DemoData>集合,查询全部数据的方法
        // 根据用户传入字段 假设我们要忽略 date
        List<PhotonImport> photonImports = photonService.dbToExcel(photonSelection);
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), PhotonExport.class).sheet("模板").doWrite(photonImports);
    }

    @PostMapping("model")
    @ApiOperation(value = "导出模板")
    public void exportExcel(HttpServletResponse response) throws IOException {
        Date date = new Date();
        String fileName = date.getTime()+ ".csv";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03版本的excel 则 传入excelType参数即可xlsx改成xls
        // 参数一：写入excel文件路径
        // 参数二：写入的数据类型是TbDemo
        //data()方法是写入的数据，结果是List<DemoData>集合,查询全部数据的方法
        // 根据用户传入字段 假设我们要忽略 date
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), PhotonModel.class).sheet("模板").doWrite(null);
    }






}
