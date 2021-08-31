package com.crledu.auto.material.photon.api.controller;

import com.alibaba.excel.EasyExcel;
import com.crledu.auto.material.photon.api.vo.*;
import com.crledu.auto.material.photon.repository.dto.*;
import com.crledu.auto.material.photon.repository.entity.Photon;
import com.crledu.auto.material.photon.repository.entity.PhotonSky;

import com.crledu.auto.material.photon.biz.service.NanoAntennaService;

import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.select.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 纳米天线
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/4
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@RestController
@RequestMapping("nano")
@Api(tags = "光电-纳米天线")
public class NanoAntennaController extends AbstractController {


    @Autowired
    private NanoAntennaService nanoAntennaService;

    @Resource
    private BaseCounterService counterService;

    @GetMapping("modelStructure1")
    @ApiOperation(value = "导出圆形结构参数模板")
    public void exportStructure1(HttpServletResponse response) throws IOException {

        String fileName = "圆形结构参数模板" + ".csv";
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
        EasyExcel.write(response.getOutputStream(), PhotonStructureCircle.class).sheet("模板").doWrite(null);
    }

    @GetMapping("modelStructure2")
    @ApiOperation(value = "导出方形结构参数模板")
    public void exportStructure2(HttpServletResponse response) throws IOException {

        String fileName = "方形结构参数模板" + ".csv";
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
        EasyExcel.write(response.getOutputStream(), PhotonStructureColumn.class).sheet("模板").doWrite(null);
    }


    @PostMapping("structure")
    @ApiOperation("提交天线-基底信息")
    public void Structure(@RequestParam(name = "topType") Integer topType, @RequestParam(name = "topConstant") Double topConstant, @RequestParam(name = "downType") Integer downType,
                          @RequestParam(name = "downConstant") Double downConstant, @RequestParam(name = "source") Integer source,
                          @RequestParam(name = "lightType") Integer lightType, @RequestParam(name = "lightAngle") Double lightAngle,
                          @RequestParam(name = "workType") Integer workType, @RequestParam(name = "file") String file,
                          MultipartFile structure, MultipartFile fake, MultipartFile real) {
        PhotonSkyDto photonSkyDto = new PhotonSkyDto(topType, topConstant, downType, downConstant, source, lightType, lightAngle, workType, file);
        PhotonSky photonSky = nanoAntennaService.createPhotonSky(photonSkyDto);
        List<Long> list = nanoAntennaService.importStructrue(structure, photonSky.getId(), photonSky.getTopType());
        nanoAntennaService.importFakeAndReal(fake, real, list, photonSky.getId());

    }


    @PostMapping("exportSky")
    @ApiOperation(value = "批量导出")
    public void dbToExcelSky(@RequestBody @Validated PhotonSkySelection photonSkySelection, HttpServletResponse response) throws IOException {


        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        Date date = new Date();
        String fileName = date.getTime() + ".xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03版本的excel 则 传入excelType参数即可xlsx改成xls
        // 参数一：写入excel文件路径
        // 参数二：写入的数据类型是TbDemo
        //data()方法是写入的数据，结果是List<DemoData>集合,查询全部数据的方法
        // 根据用户传入字段 假设我们要忽略 date
        if (photonSkySelection.getTopType().startsWith("圆")) {
            List<NanoAntennaCircleVo> photonImports = nanoAntennaService.selectCircleList(photonSkySelection);
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            EasyExcel.write(response.getOutputStream(), NanoAntennaCircleVo.class).sheet("天线").doWrite(photonImports);
        } else {
            List<NanoAntennaColumnVo> photonImports = nanoAntennaService.selectColumnList(photonSkySelection);
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            EasyExcel.write(response.getOutputStream(), NanoAntennaColumnVo.class).sheet("天线").doWrite(photonImports);
        }


    }

    @PostMapping
    @ApiOperation(value = "查询天线列表")
    public Response<PageDate<PhotonSkyVo>> selectSkyList(@RequestBody PhotonSkySelection photonSkySelection) {
        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        return new Response().success(nanoAntennaService.selectSkyList(photonSkySelection));
    }


    @PostMapping("structureNew")
    @ApiOperation("提交天线-基底信息新版")
    public Response StructureNew(@RequestParam(name = "topType") Integer topType, @RequestParam(name = "topConstant") Double topConstant, @RequestParam(name = "downType") Integer downType,
                             @RequestParam(name = "downConstant") Double downConstant, @RequestParam(name = "source") Integer source,
                             @RequestParam(name = "lightType") Integer lightType, @RequestParam(name = "lightAngle") Double lightAngle,
                             @RequestParam(name = "workType") Integer workType, @RequestParam(name = "file") String file,
                             MultipartFile structure, MultipartFile fake, MultipartFile real) {
        PhotonSkyDto photonSkyDto = new PhotonSkyDto(topType, topConstant, downType, downConstant, source, lightType, lightAngle, workType, file);
        nanoAntennaService.createPhotonSkyNew(photonSkyDto, structure, fake, real);
        return new Response<>().success();

    }

    @PostMapping("NanoAntenna")
    @ApiOperation("提交天线材料--新版")
    public Response NanoAntennaNew( NanoAntennaCreateVo createVo, @RequestParam(name = "structure")MultipartFile structure,
                                   @RequestParam(name ="fake")MultipartFile fake,@RequestParam(name = "real")MultipartFile real,@RequestParam(name = "process",required = false)MultipartFile process){
        nanoAntennaService.createNanoAntennaNew(createVo,loginUser().getId(),structure,fake,real,process);

        return new Response().success();
    }

    @PostMapping("save")
    @ApiOperation("保存天线材料--新版")
    public Response saveAntennaNew( NanoAntennaCreateVo createVo, @RequestParam(name = "structure")MultipartFile structure,
                                    @RequestParam(name ="fake")MultipartFile fake,@RequestParam(name = "real")MultipartFile real,@RequestParam(name = "process",required = false)MultipartFile process){
        nanoAntennaService.saveNanoAntennaNew(createVo,loginUser().getId(),structure,fake,real,process);

        return new Response().success();
    }



    @GetMapping("selectStructure")
    @ApiOperation(value = "查询天线结构参数")
    public Response<PageDate<PhotonSkyVoNew>> selectSkyListNew(PhotonSkySelectionNew PhotonSkySelectionNew) {
        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        return new Response().success(nanoAntennaService.selectSkyListNew(PhotonSkySelectionNew));
    }

    @GetMapping("selectMap")
    @ApiOperation(value = "查询天线曲线图")
    public Response<List<PhotonSkyMapVo>> selectSkyListMap(PhotonSkySelectionMap photonSkySelectionMap) {
        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        return new Response().success(nanoAntennaService.selectSkyListMap(photonSkySelectionMap));
    }


    @PostMapping("exportSkyNew")
    @ApiOperation(value = "批量导出新版")
    public void dbToExcelSkyNew(@RequestBody PhotonSkySelectionNew selectionNew, HttpServletResponse response) throws IOException {


        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        Date date = new Date();
        String fileName = date.getTime() + ".xlsx";
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03版本的excel 则 传入excelType参数即可xlsx改成xls
        // 参数一：写入excel文件路径
        // 参数二：写入的数据类型是TbDemo
        //data()方法是写入的数据，结果是List<DemoData>集合,查询全部数据的方法
        // 根据用户传入字段 假设我们要忽略 date

        List<PhotonSkyVoNew> photonImports = nanoAntennaService.selectSkyListNew(selectionNew).getRows();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), PhotonSkyMapVo.class).sheet("天线").doWrite(photonImports);


    }


    @GetMapping("selectMapNew")
    @ApiOperation(value = "查询天线曲线图新")
    public Response<List<PhotonSkyMapVo>> selectSkyListMapNew(SelectionMapNew selectionMapNew) {
        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        return new Response().success(nanoAntennaService.selectSkyListMapNew(selectionMapNew));
    }

    @GetMapping("selectNanoAntenna")
    @ApiOperation(value = "天线曲线图")
    public Response<List<PhotonSkyMapVo>> selectNanoAntenna(PhotonSkySelectionMap photonSkySelectionMap){
        counterService.addVisiter(DataTypeEnum.NANO_ANTENNA);
        return new Response<>().success(nanoAntennaService.selectNanoAntenna(photonSkySelectionMap));
    }


}
