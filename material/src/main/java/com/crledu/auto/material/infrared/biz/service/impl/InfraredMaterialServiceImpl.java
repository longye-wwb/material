package com.crledu.auto.material.infrared.biz.service.impl;

import com.crledu.auto.material.base.service.annotation.ColumnName;
import com.crledu.auto.material.bigdata.biz.thread.BuildDataPackage;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingVo;
import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.domain.*;
import com.crledu.auto.material.infrared.biz.dto.*;
import com.crledu.auto.material.infrared.biz.repository.BaseMicrowaveAbsordingLayerImportDataDomainRepository;
import com.crledu.auto.material.infrared.biz.repository.BaseProjectionLayerDomainRepository;
import com.crledu.auto.material.infrared.biz.service.BaseInfraredMaterialService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.crledu.auto.web.response.PageDate;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 ************************************************************
 * @Description: 微波红外兼容材料数据导入相关服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:37
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredMaterialServiceImpl  implements BaseInfraredMaterialService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String FILE_SPLITER_KEY = "infrared";
    private final String STRUCT_FILE_KEY = "struct";
    private final String PROJECTION_FILE_KEY = "projection";
    private final String ABSORBING_FILE_KEY = "absorbing";

    private static final Logger log = LoggerFactory.getLogger(InfraredMaterialServiceImpl.class);

    @Resource
    private BaseProjectionLayerDomainRepository projectionLayerDomainRepository;

    @Resource
    private BaseMicrowaveAbsordingLayerImportDataDomainRepository microwaveAbsorbingLayerImportDataDomainRepository;

    @Resource
    private BaseImportDataService importDataService;

    @Override
    public void saveProjectionData(ProjectionLayerImportDto importDto) {
        ImportDataItemDto importDataItemDto = saveDataInHistory(importDto);
        importDto.setId(importDataItemDto.getId());
        //解析数据
        List<String[]> structData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(STRUCT_FILE_KEY));
        List<String[]> transMissivityData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(PROJECTION_FILE_KEY));
        if(structData.size() == transMissivityData.size()){
            //数据行数对应
            parseProjectionData(structData,transMissivityData,importDto);
            BuildDataPackage buildPackage = new BuildDataPackage(importDto.getId(),basePath);
            buildPackage.start();
        }else{
            throw new RestRuntimeException("导入数据结构参数和结果行数不对应","1900000301");
        }
    }

    @Override
    public void saveMicrowaveAbsorbingData(MicrowaveAbsorbingLayerImportDto importDto) {
        ImportDataItemDto importDataItemDto = saveDataInHistory(importDto);
        importDto.setId(importDataItemDto.getId());
        //解析表格数据
        List<String[]> structData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(STRUCT_FILE_KEY));
        List<String[]> absorbingData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(ABSORBING_FILE_KEY));
        if(structData.size() == absorbingData.size()){
            //数据行数对应
            parseMicrowaveAbsorbingData(structData,absorbingData,importDto);
            BuildDataPackage buildPackage = new BuildDataPackage(importDto.getId(),basePath);
            buildPackage.start();
        }else{
            throw new RestRuntimeException("1900000301","导入数据结构参数和结果行数不对应");
        }

    }

    @Override
    public void buildProjectionTemplateFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String fileName="template.csv";
        String userAgent = request.getHeader("User-Agent");
        String[] line = new String[3];
        line[0] = "dpvc0";
        line[1] = "d0";
        line[2] = "p0";
        List<String[]> content = new ArrayList<>();
        content.add(line);
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
        response.setContentType("application/octet-stream");
        CSVFileUtils.writeDataToFile(response.getOutputStream(),content,',');
    }

    private void parseProjectionData(List<String[]> structData,List<String[]> transMissivityData,ProjectionLayerImportDto importDto){
        String BASE_THICKNESS_PARAM_KEY = "dpvc0";
        String BASE_WIDTH_PARAM_KEY = "d0";
        String BASE_PERIOD_PARAM_KEY = "p0";
        //获取结构参数的表头
        String[] structHeader = structData.get(0);
        Integer periodIndex = 100;
        Integer widthIndex = 100;
        Integer thicknessIndex = 100;
        for(int i = 0;i<structHeader.length;i++){
            if(structHeader[i].trim().equals(BASE_PERIOD_PARAM_KEY)){
                periodIndex = i;
            }else if(structHeader[i].trim().equals(BASE_WIDTH_PARAM_KEY)){
                widthIndex = i;
            }else if(structHeader[i].trim().equals(BASE_THICKNESS_PARAM_KEY)){
                thicknessIndex = i;
            }
        }
        //验证数据完整性
        if(periodIndex>=100||widthIndex>=100||thicknessIndex>=100){
            throw new RestRuntimeException("1900000202","结构的表格数据不完整。");
        }
        //获取导入数据的头部
        String [] transmissivityHeader = transMissivityData.get(0);
        if(importDto.getSaveData()){
            projectionLayerDomainRepository.emptyTable();
        }
        for(int j = 1;j < structData.size() ; j++){
            saveInfraredMaterialData(structData.get(j),periodIndex,widthIndex,thicknessIndex,transMissivityData.get(j),transmissivityHeader,importDto);
        }
    }

    @Override
    public void buildMicrowaveAbsorbingTemplateFile(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String fileName="template.csv";
        String userAgent = request.getHeader("User-Agent");
        String[] line = new String[6];
        line[0] = "dpvc2";
        line[1] = "R2";
        line[2] = "l2";
        line[3] = "dpvc1";
        line[4] = "R1";
        line[5] = "l1";
        List<String[]> content = new ArrayList<>();
        content.add(line);
        // 针对IE或者以IE为内核的浏览器：
        if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
            fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
        } else {
            // 非IE浏览器的处理：
            fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
        response.setHeader("Content-Disposition",  String.format("attachment; filename=%s", fileName));
        response.setContentType("application/octet-stream");
        CSVFileUtils.writeDataToFile(response.getOutputStream(),content,',');
    }

    private void parseMicrowaveAbsorbingData(List<String[]> structData,List<String[]> absorbing,MicrowaveAbsorbingLayerImportDto importDto){
        String SECOND_THICKNESS_PARAM_KEY = "dpvc2";
        String SECOND_RESISTANCE_VALUE_PARAM_KEY = "R2";
        String SECOND_RESISTANCE_SIDE_PARAM_KEY = "l2";
        String FIRST_THICKNESS_PARAM_KEY = "dpvc1";
        String FIRST_RESISTANCE_VALUE_PARAM_KEY = "R1";
        String FIRST_RESISTANCE_SIDE_PARAM_KEY = "l1";
        //获取结构参数的表头
        String[] structHeader = structData.get(0);
        List<Integer[]> headers = new ArrayList<>();
        headers.add(new Integer[3]);
        headers.add(new Integer[3]);
        for(int i = 0;i<structHeader.length;i++){
            if(structHeader[i].trim().equals(FIRST_RESISTANCE_SIDE_PARAM_KEY)){
                headers.get(0)[0] = i;
            }else if(structHeader[i].trim().equals(FIRST_RESISTANCE_VALUE_PARAM_KEY)){
                headers.get(0)[1] = i;
            }else if(structHeader[i].trim().equals(FIRST_THICKNESS_PARAM_KEY)){
                headers.get(0)[2] = i;
            }else if(structHeader[i].trim().equals(SECOND_RESISTANCE_SIDE_PARAM_KEY)){
                headers.get(1)[0] = i;
            }else if(structHeader[i].trim().equals(SECOND_RESISTANCE_VALUE_PARAM_KEY)){
                headers.get(1)[1] = i;
            }else if(structHeader[i].trim().equals(SECOND_THICKNESS_PARAM_KEY)){
                headers.get(1)[2] = i;
            }
        }
        //获取数据的头部波长
        String[] dataHeader = absorbing.get(0);
        if(importDto.getSaveInData()){
            microwaveAbsorbingLayerImportDataDomainRepository.emptyTable();
        }
        for(int j = 1;j<absorbing.size();j++){
            saveInfraredMaterialData(structData.get(j),headers,absorbing.get(j),absorbing.get(0),importDto);
        }
    }

    private void saveInfraredMaterialData(String[] struct, List<Integer[]> headers,String[] data,String[] waveData,MicrowaveAbsorbingLayerImportDto importDto){

        //分析导入的数据有多少个功能层
        List<MicrowaveAbsorbingLayerDomain> layers = new ArrayList<>();
        if(importDto.getLayerItemVos()!= null || importDto.getLayerItemVos().size()>0){
            for(int i = 0;i<importDto.getLayerItemVos().size();i++){
                layers.add(
                        MicrowaveAbsorbingLayerDomain.getInstance(
                                importDto.getLayerItemVos().get(i).getShape(),
                                Float.valueOf(struct[headers.get(i)[0]]),
                                Float.valueOf(struct[headers.get(i)[1]]),
                                importDto.getLayerItemVos().get(i).getBaseMaterial(),
                                importDto.getLayerItemVos().get(i).getBaseDielectricConstant(),
                                importDto.getLayerItemVos().get(i).getDielectricMaterial(),
                                importDto.getLayerItemVos().get(i).getDielectricConstant(),
                                Float.valueOf(struct[headers.get(i)[2]])
                        )
                );
            }
        }
        //分析吸收率参数
        List<AbsorbingDataItemDto> absorbingItemDtoList = new ArrayList<>();
        for(int j = 1 ; j < waveData.length ; j++){
            AbsorbingDataItemDto absorbingItemDto = new AbsorbingDataItemDto();
            absorbingItemDto.setWavelength(Float.valueOf(waveData[j]));
            absorbingItemDto.setAbsorbing(Float.valueOf(data[j]));
            absorbingItemDtoList.add(absorbingItemDto);
        }

        MicrowaveAbsordingLayerImportDataDomain importDataDomain = MicrowaveAbsordingLayerImportDataDomain.getInstance(importDto.getId(),layers,importDto.getPeriod(),importDto.getDataFrom(),importDto.getLightAngle(),absorbingItemDtoList,importDto.getSaveInData());
        microwaveAbsorbingLayerImportDataDomainRepository.saveInData(importDataDomain);
    }

    private void saveInfraredMaterialData(String[] struct,Integer periodIndex,Integer widthIndex,Integer thicknessIndex,String[] data,String[] waveData,ProjectionLayerImportDto importDto){
        //分析基底层数据 由于实际可能没有
        ProjectionLayerBaseDomain baseDomain = null;
        if(importDto.getBaseMaterial().isEmpty()||importDto.getBaseDielectric() == null||importDto.getBaseEmissivity()==null){
            //基底层没有数据不做任何处理
            log.debug("当前数据没有微波透射层基底");
        }else{
            baseDomain = ProjectionLayerBaseDomain.getInstance(importDto.getBaseMaterial(),null,importDto.getBaseDielectric(),importDto.getBaseEmissivity());
        }
        //分析介质层数据
        String dielectricThicknessStr = struct[thicknessIndex];
        ProjectionLayerDielectricDomain dielectricDomain = ProjectionLayerDielectricDomain.getInstance(importDto.getDielectricMaterial(),Float.valueOf(dielectricThicknessStr),importDto.getDielectricConstant(),importDto.getDielectricEmissivity());
        //分析金属贴片层数据
        String patchPeriodStr = struct[periodIndex];
        String patchWidth = struct[widthIndex];
        ProjectionLayerMetalPatchDomain patchDomain = ProjectionLayerMetalPatchDomain.getInstance(importDto.getPatchMaterial(),importDto.getPatchEmissivity(),Float.valueOf(patchPeriodStr),Float.valueOf(patchWidth));
        //合成投射层的透射率数据
        List<ProjectionDataItemDto> projectionDataItemDtos = new ArrayList<>();
        for(int i = 1;i<waveData.length;i++){
            Float waveLength = Float.valueOf( waveData[i]);
            Float projection = Float.valueOf(data[i]);
            ProjectionDataItemDto itemDto = new ProjectionDataItemDto();
            itemDto.setProjection(projection);
            itemDto.setWavelength(waveLength);
            projectionDataItemDtos.add(itemDto);
        }
        ProjectionLayerDomain projectionLayerDomain = ProjectionLayerDomain.getInstance(importDto.getId(),baseDomain,dielectricDomain,patchDomain,importDto.getDataFrom(),importDto.getLightAngle(),projectionDataItemDtos,importDto.getSaveData());
        projectionLayerDomainRepository.saveInData(projectionLayerDomain);
    }

    private ImportDataItemDto saveDataInHistory(MicrowaveAbsorbingLayerImportDto importDto){
        ImportDataCreateDto createDto = new ImportDataCreateDto();
        createDto.setType(5);
        createDto.setCreator(importDto.getCreator());
        createDto.setDataFrom(importDto.getDataFrom());
        createDto.setProcess(importDto.getProcess());
        //拼接附件键值对
        Map<String,MultipartFile> fileMap = new HashedMap();
        fileMap.put(ABSORBING_FILE_KEY,importDto.getData());
        fileMap.put(STRUCT_FILE_KEY,importDto.getStruct());
        createDto.setFiles(fileMap);
        //拼接其他结构参数
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("period",importDto.getPeriod());
        paramMap.put("lightAngle",importDto.getLightAngle());
        paramMap.put("layers",importDto.getLayerItemVos());
        createDto.setForm(paramMap);
        return importDataService.saveInHistory(createDto, DataTypeEnum.MICRO_ABSORBING);
    }

    private ImportDataItemDto saveDataInHistory(ProjectionLayerImportDto importDto){
        ImportDataCreateDto createDto = new ImportDataCreateDto();
        createDto.setType(4);
        createDto.setProcess(importDto.getProcess());
        createDto.setDataFrom(importDto.getDataFrom());
        createDto.setCreator(importDto.getCreator());
        //拼接附件键值对
        Map<String,MultipartFile> fileMap = new HashMap<>();
        fileMap.put(STRUCT_FILE_KEY,importDto.getStruct());
        fileMap.put(PROJECTION_FILE_KEY,importDto.getData());
        createDto.setFiles(fileMap);
        //拼接其他结构参数
        Map<String,Object> paramMap = new HashedMap();
        paramMap.put("lightAngle",importDto.getLightAngle());
        paramMap.put("PatchMaterial",importDto.getPatchMaterial());
        paramMap.put("patchEmissivity",importDto.getPatchEmissivity());
        paramMap.put("baseMaterial",importDto.getBaseMaterial());
        paramMap.put("baseDielectric",importDto.getBaseDielectric());
        paramMap.put("baseEmissivity",importDto.getBaseEmissivity());
        paramMap.put("dielectricMaterial",importDto.getDielectricMaterial());
        paramMap.put("dielectricConstant",importDto.getDielectricConstant());
        paramMap.put("dielectricEmissivity",importDto.getDielectricEmissivity());
        createDto.setForm(paramMap);
        return importDataService.saveInHistory(createDto,DataTypeEnum.INFRARED_PROJECTION);
    }

    @Override
    public PageDate<ProjectionVo> selectProjectionList(ProjectionSelectDto projectionSelectDto) {
        return projectionLayerDomainRepository.selectProjectionList(projectionSelectDto);

    }

    @Override
    public ProjectionVo selectProjectionInfo(Long id) {
        return projectionLayerDomainRepository.selectInfo(id);
    }

    @Override
    public PageDate<MicrowaveAbsorbingVo> selectAbsorbingList(MicrowaveAbsorbingSelectDto selectDto) {
        return microwaveAbsorbingLayerImportDataDomainRepository.selectAbsorbingList(selectDto);
    }

    @Override
    public MicrowaveAbsorbingVo selectAbsorbingInfo(Long id) {
        return microwaveAbsorbingLayerImportDataDomainRepository.selectInfo(id);
    }
}
