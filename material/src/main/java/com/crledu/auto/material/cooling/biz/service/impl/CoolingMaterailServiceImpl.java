package com.crledu.auto.material.cooling.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.bigdata.biz.thread.BuildDataPackage;
import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailDataDomain;
import com.crledu.auto.material.cooling.biz.dto.*;
import com.crledu.auto.material.cooling.biz.repository.BaseCoolingMaterailDataDomainRepository;
import com.crledu.auto.material.cooling.biz.service.BaseCoolingMaterailService;
import com.crledu.auto.material.cooling.repository.dao.BaseCoolingMaterailMapper;
import com.crledu.auto.material.cooling.repository.entity.CoolingMaterailEntity;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.file.CSVFileUtils;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.crledu.auto.web.response.PageDate;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 ************************************************************
 * @Description: 辐射制冷材料相关服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 9:57
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class CoolingMaterailServiceImpl implements BaseCoolingMaterailService {
    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String ABSORBING_FILE_KEY = "absorbing";
    private final String STRUCT_FILE_KEY = "struct";
    private final String LAYER_AMOUNT_KEY = "layer";

    @Resource
    private BaseCoolingMaterailDataDomainRepository coolingMaterailDataDomainRepository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseCoolingMaterailMapper coolingMaterialMapper;

    @Resource
    private BaseCounterService counterService;

    @Override
    public void importCoolingMaterialData(CoolingMetatailImportDto importData) {
        //保存资源文件
        ImportDataItemDto importDataItemDto = saveDataIntoHistory(importData);
        importData.setImportId(importDataItemDto.getId());
        //数据解析
        List<String[]> absorbingData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(ABSORBING_FILE_KEY));
        List<String[]> structData = CSVFileUtils.readCsv(importDataItemDto.getFiles().get(STRUCT_FILE_KEY));
        if(absorbingData.size() == structData.size()){
            if(importData.getSaveData()){
                QueryWrapper<CoolingMaterailEntity> queryWrapper = new QueryWrapper<>();
                queryWrapper.isNotNull("id");
                coolingMaterialMapper.delete(queryWrapper);
            }
            if(importData.getType() == 1){
                praseMileData(absorbingData,structData,importData);
            }else{
                praseDoubleLayerData(absorbingData,structData,importData);
            }
            BuildDataPackage buildPackage = new BuildDataPackage(importData.getImportId(),basePath);
            buildPackage.start();
        }else{
            throw new RestRuntimeException("1900000201","导入数据结构参数和结果行数不对应");
        }
    }

    private void praseMileData(List<String[]> absorbingData,List<String[]> structData,CoolingMetatailImportDto importData){
        String[] structHeader = structData.get(0);
        String[] absorbingHeader = absorbingData.get(0);
        Integer[] heightArray = new Integer[10];
        Integer layerIndex = 100;
        //多层膜结构
        for(int i = 0 ; i<structHeader.length ; i++){
            //判断是不是厚度
            if(structHeader[i] == null||structHeader[i].isEmpty()){
                //当前各自是空格子
            }else{
                String item = structHeader[i];
                if(item.trim().startsWith("h")){
                    String rowStr = item.trim().substring(1);
                    heightArray[new Integer(rowStr)-1] = i;
                }else if(item.trim().equals(LAYER_AMOUNT_KEY)){
                    layerIndex = i;
                }
            }
        }
        for(int j = 1 ; j < structData.size() ; j++){
            String[] structArray = structData.get(j);
            String[] absorbingArray = absorbingData.get(j);
            saveCoolingMaterial(absorbingData.get(0),absorbingArray,layerIndex,heightArray,null,structArray,importData);
        }
    }

    private void saveCoolingMaterial(String[] waveLength,String[] absorbing,Integer layers,Integer[] heightIndex,Integer[] dIndex,String[] structData,CoolingMetatailImportDto importDataItemDto){
        CoolingMaterialCreateDto coolingMaterialCreateDto = new CoolingMaterialCreateDto();
        coolingMaterialCreateDto.setImportId(importDataItemDto.getImportId());
        //构建厚度数组
        List<Float> heightList = new ArrayList<>();
        for(int i = 0 ; i < heightIndex.length ; i++){
            if(heightIndex[i] != null){
                heightList.add(Float.valueOf(structData[heightIndex[i]]));
            }
        }
        coolingMaterialCreateDto.setThicknessList(heightList);
        //构建直径数组
        if(dIndex != null){
            List<Float> radList = new ArrayList<>();
            for(int i = 0 ; i < dIndex.length ; i++){
                if(dIndex[i] != null){
                    radList.add(Float.valueOf(structData[dIndex[i]]));
                }
            }
            coolingMaterialCreateDto.setDiameterList(radList);
        }else{
            coolingMaterialCreateDto.setDiameterList(null);
        }
        coolingMaterialCreateDto.setBaseMaterial(importDataItemDto.getBottomMaterail());
        coolingMaterialCreateDto.setFirstMaterial(importDataItemDto.getFirstMaterail());
        coolingMaterialCreateDto.setSecondMaterial(importDataItemDto.getSecondMetarail());
        coolingMaterialCreateDto.setDataFrom(importDataItemDto.getDataFrom());
        List<AbsorbingItemDto> absorbingItemDtoList = new ArrayList<>();
        for(int j = 1 ; j < waveLength.length ; j++){
            AbsorbingItemDto absorbingItemDto = new AbsorbingItemDto();
            absorbingItemDto.setWaveLength(Float.valueOf(waveLength[j]));
            absorbingItemDto.setAbsorbing(Float.valueOf(absorbing[j]));
            absorbingItemDtoList.add(absorbingItemDto);
        }
        coolingMaterialCreateDto.setAbsorbingItemDtos(absorbingItemDtoList);
        if(importDataItemDto.getType() == 1){
            coolingMaterialCreateDto.setLayers(Integer.valueOf(structData[layers]));
        }else{
            coolingMaterialCreateDto.setLayers(2);
        }
        coolingMaterialCreateDto.setLightAngle(importDataItemDto.getLightAngle());
        coolingMaterialCreateDto.setLightType(importDataItemDto.getLightType());
        coolingMaterialCreateDto.setPeriod(null);
        coolingMaterialCreateDto.setType(importDataItemDto.getType());
        coolingMaterialCreateDto.setWorkingMode(importDataItemDto.getWorkingMode());
        CoolingMaterailDataDomain coolingMaterailDataDomain = CoolingMaterailDataDomain.getInstance(coolingMaterialCreateDto);
        coolingMaterailDataDomainRepository.saveInData(coolingMaterailDataDomain);
    }

    private void praseDoubleLayerData(List<String[]> absorbingData,List<String[]> structData,CoolingMetatailImportDto importData){
        String[] structHeader = structData.get(0);
        String[] absorbingHeader = absorbingData.get(0);
        Integer[] heightArray = new Integer[2];
        Integer layerIndex = 100;
        Integer[] diameterArray = new Integer[2];
        //双层圆柱
        for(int i = 0 ; i < structHeader.length ; i++){
            //判断是不是厚度
            if(structHeader[i] == null||structHeader[i].isEmpty()){
                //当前各自是空格子
            }else{
                String item = structHeader[i];
                if(item.trim().startsWith("h_")){

                }else if(item.trim().startsWith("h")){
                    String rowStr = item.trim().substring(1);
                    heightArray[new Integer(rowStr)] = i;
                }else if(item.trim().startsWith("d")){
                    String rowStr = item.trim().substring(1);
                    diameterArray[new Integer(rowStr)] = i;
                }
            }
        }
        for(int j = 1 ; j < structData.size() ; j++){
            String[] structArray = structData.get(j);
            String[] absorbingArray = absorbingData.get(j);
            saveCoolingMaterial(absorbingData.get(0),absorbingArray,layerIndex,heightArray,diameterArray,structArray,importData);
        }

    }

    @Override
    public PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto) {
        counterService.addVisiter(DataTypeEnum.COOLING_MATERAIL);
        return coolingMaterailDataDomainRepository.selectCoolingMaterial(selectDto);
    }

    @Override
    public CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto) {
        counterService.addVisiter(DataTypeEnum.COOLING_MATERAIL);
        return null;
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {

    }

    private ImportDataItemDto saveDataIntoHistory(CoolingMetatailImportDto importData){
        ImportDataCreateDto createDto = new ImportDataCreateDto();
        createDto.setCreator(importData.getCreator());
        createDto.setDataFrom(importData.getDataFrom());
        Map<String,MultipartFile> fileMap = new HashedMap();
        fileMap.put(ABSORBING_FILE_KEY,importData.getAbs());
        fileMap.put(STRUCT_FILE_KEY,importData.getLayers());
        createDto.setFiles(fileMap);
        Map<String,Object> map = new HashMap<>();
        map.put("bottomMaterail",importData.getBottomMaterail());
        map.put("firstMaterail",importData.getFirstMaterail());
        map.put("secondMetarail",importData.getSecondMetarail());
        map.put("lightType",importData.getLightType());
        map.put("lightAngle",importData.getLightAngle());
        map.put("workingMode",importData.getWorkingMode());
        createDto.setForm(map);
        createDto.setProcess(importData.getProcess());
        createDto.setType(3);
        return importDataService.saveInHistory(createDto, DataTypeEnum.COOLING_MATERAIL);
    }
}
