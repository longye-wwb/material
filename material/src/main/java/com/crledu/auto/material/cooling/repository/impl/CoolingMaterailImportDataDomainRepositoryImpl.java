package com.crledu.auto.material.cooling.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailDataDomain;
import com.crledu.auto.material.cooling.biz.domain.CoolingMaterailImportDataDomain;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialAbsorSelectDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialInfoDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialItemDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialSelectDto;
import com.crledu.auto.material.cooling.biz.repository.BaseCoolingMaterailImportDataDomainRepository;
import com.crledu.auto.material.cooling.repository.dao.BaseCoolingMaterailMapper;
import com.crledu.auto.material.impor.repository.dao.BaseImportDataHistoryMapper;
import com.crledu.auto.material.cooling.repository.entity.CoolingMaterailEntity;
import com.crledu.auto.material.impor.repository.entity.ImportDataHistoryEntity;
import com.crledu.auto.system.dto.SavedFileInfo;
import com.crledu.auto.system.repository.BaseSystemFileRepository;
import com.crledu.auto.web.response.PageDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 ************************************************************
 * @Description: 辐射制冷导入数据仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/13 9:23
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class CoolingMaterailImportDataDomainRepositoryImpl implements BaseCoolingMaterailImportDataDomainRepository {

    @Value("${crledu.auto.file.server}")
    private String baseUrl;

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataHistoryMapper importDataHistoryMapper;

    @Resource
    private BaseSystemFileRepository systemFileRepository;

    @Resource
    private BaseCoolingMaterailMapper coolingMaterailMapper;

    @Override
    public CoolingMaterailImportDataDomain createWithData(Long id) {
        return null;
    }

    @Override
    public CoolingMaterailImportDataDomain saveInData(CoolingMaterailImportDataDomain domain) {
        //保存资源文件
        String baseFilename = basePath+ File.separator+ Long.valueOf(System.currentTimeMillis()).toString();
        //保存程序文件
        String processFile = saveProcess(domain,baseFilename);
        //保存数据文件
        Map<String,String> fileNameMap = new HashMap<>();
        Set<String> fileKeys = domain.getFiles().keySet();
        for(String name: fileKeys){
            String path = saveDataFile(domain.getFiles().get(name),baseFilename,name);
            fileNameMap.put(name,path);
        }
        //保存数据到导入历史
        saveIntoImportHistory(processFile,fileNameMap,domain);
        //保存导入数据
        List<CoolingMaterailDataDomain> dataDomainList = domain.paresImpordata();
        if(dataDomainList!=null){
            List<CoolingMaterailEntity> dataEntitys = new ArrayList<>();
            Integer index = 1;
            for(CoolingMaterailDataDomain dataDomain:dataDomainList){
                CoolingMaterailEntity entity = buileEntity(dataDomain,domain.getDataFrom(),baseFilename,index);
                dataEntitys.add(entity);
                coolingMaterailMapper.insert(entity);
            }
        }
        //循环保存辐射制冷数据
        return domain;
    }

    @Override
    public CoolingMaterailImportDataDomain updateToData(CoolingMaterailImportDataDomain domain) {
        return null;
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    private String saveProcess(CoolingMaterailImportDataDomain dataDomain,String basePath){
        String filename = dataDomain.getProcess().getName();
        String realName = filename.replace(dataDomain.getProcess().getParent(),"");
        String processFilename = basePath + "process_"+realName;
        SavedFileInfo savedFileInfo = new SavedFileInfo();
        savedFileInfo.setPath(processFilename);
        systemFileRepository.save(dataDomain.getProcess(),savedFileInfo);
        return processFilename;
    }

    private String saveDataFile(File file,String basePath,String name){
        String filename = file.getName();
        String realName = filename.replace(file.getParent(),"");
        String processFilename = basePath + name+"_"+realName;
        SavedFileInfo savedFileInfo = new SavedFileInfo();
        savedFileInfo.setPath(processFilename);
        systemFileRepository.save(file,savedFileInfo);
        return processFilename;
    }

    private String saveDataToFile(List<List<Float>> absorptivity,String path,String name){
        File pathFile = new File(path);
        if(!pathFile.exists()){
            pathFile.mkdirs();
        }
        String baseDataFile = path +File.separator + name;
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(baseDataFile,true));
            bw.write(JSON.toJSONString(absorptivity));
           bw.flush();
           bw.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return baseDataFile;
    }

    private ImportDataHistoryEntity saveIntoImportHistory(String processFile, Map<String,String> fileNameMap,CoolingMaterailImportDataDomain dataDomain){
        ImportDataHistoryEntity importDataHistoryEntity = new ImportDataHistoryEntity();
        importDataHistoryEntity.setCreateTime(new Date());
        importDataHistoryEntity.setCreator(dataDomain.getCreator());
        importDataHistoryEntity.setCurStatus(1);
        importDataHistoryEntity.setDataFrom(dataDomain.getDataFrom());
        importDataHistoryEntity.setFiles(JSON.toJSONString(fileNameMap));
        importDataHistoryEntity.setForm(JSON.toJSONString(dataDomain.getForm()));
        importDataHistoryEntity.setProcess(processFile);
        importDataHistoryMapper.insert(importDataHistoryEntity);
        return importDataHistoryEntity;
    }

    private CoolingMaterailEntity buileEntity(CoolingMaterailDataDomain dataDomain,Integer dataForm,String baseFilename,Integer index){
        String path = baseFilename + File.separator+"data";
        String name = index.toString()+".json";
        CoolingMaterailEntity coolingMaterailEntity = new CoolingMaterailEntity();
        coolingMaterailEntity.setAbsorptivity(saveDataToFile(null,path,name));
        coolingMaterailEntity.setBase(JSON.toJSONString(dataDomain.getBaseMaterial()));
        coolingMaterailEntity.setDataFrom(dataForm);
        coolingMaterailEntity.setLayer(JSON.toJSONString(dataDomain.getLayers()));
        coolingMaterailEntity.setLightAngle(dataDomain.getLightAngle());
        coolingMaterailEntity.setLightType(dataDomain.getLightType());
        coolingMaterailEntity.setThickness(dataDomain.getThickness());
        coolingMaterailEntity.setType(dataDomain.getType());
        coolingMaterailEntity.setWorkingMode(dataDomain.getWorkingMode());
        return coolingMaterailEntity;
    }

    @Override
    public PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto) {
        Page<CoolingMaterialItemDto> page = new Page<>(selectDto.getPageNum(),selectDto.getPageSize());
        page.setRecords(coolingMaterailMapper.selectCoolingMaterial(selectDto,page));
        return new PageDate<>(page);
    }

    @Override
    public CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto) {

        CoolingMaterailEntity entity = coolingMaterailMapper.selectById(selectDto.getId());
        if( entity!= null){
            String dataFile = entity.getAbsorptivity();
            String result = "";
            try{
               BufferedReader br = new BufferedReader(new FileReader(dataFile));
               String temp = null;
               while ((temp = br.readLine()) != null){
                   result += temp;
               }

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return buildInfoDto(entity,result);
        }
        return null;
    }

    private CoolingMaterialInfoDto buildInfoDto(CoolingMaterailEntity entity,String absor){
        CoolingMaterialInfoDto infoDto = new CoolingMaterialInfoDto();
        infoDto.setAbs(absor);
        infoDto.setBase(entity.getBase());
        infoDto.setDataFrom(entity.getDataFrom());
        infoDto.setId(entity.getId());
        infoDto.setLayer(entity.getLayer());
        infoDto.setLightAngle(entity.getLightAngle());
        infoDto.setLightType(entity.getLightType());
        infoDto.setThickness(entity.getThickness());
        infoDto.setType(entity.getType());
        infoDto.setWorkingMode(entity.getWorkingMode());
        return infoDto;
    }
}
