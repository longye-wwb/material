package com.crledu.auto.material.second.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.second.biz.domain.DiffractionDomian;
import com.crledu.auto.material.second.biz.dto.DiffractionImportDto;
import com.crledu.auto.material.second.biz.repository.BaseDiffractionRepository;
import com.crledu.auto.material.second.biz.service.BaseDiffractionService;
import com.crledu.auto.material.second.repository.dao.BaseDiffractionMapper;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.utils.ImageUtils;
import com.crledu.auto.material.utils.MatlabFileUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DiffractionServiceImpl extends AbstractImportService<DiffractionDomian> implements BaseDiffractionService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseDiffractionRepository repository;

    @Resource
    private BaseDiffractionMapper mapper;

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {

        ImportDataItemDto result = importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.DIFFRACTION);
        List<List<String>> struct = new ArrayList<>();
        //适配衍射组件附件解析
        if(result.getFiles().containsKey(METLAB_FILE_KEY)){
            struct.add(new ArrayList<>());
            struct.get(0).add("picture");
            try {
                double[][][] maps = MatlabFileUtils.readDoubleMatFile(result.getFiles().get(METLAB_FILE_KEY),"structure");
                for(int i =0;i<maps.length;i++){
                    String fileName = "structure" + i ;
                    String path = importDataService.savePictrue(ImageUtils.createGrayPicture(maps[i]),result.getId(),fileName);
                    struct.add(new ArrayList<>());
                    struct.get(i + 1).add(path);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //转换数据格式
        List<String[]> structData = new ArrayList<>();
        for(List<String> item:struct){
            String[] dataArray = new String[item.size()];
            dataArray = item.toArray(dataArray);
            structData.add(dataArray);
        }
        result.setStructData(structData);
        return result;
    }

    @Override
    protected void saveDomain(DiffractionDomian domain) {
        repository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return DiffractionDomian.class;
    }

    @Override
    protected void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("id");
        mapper.delete(queryWrapper);
    }

    @Override
    protected void setDataTotal(Long id, Integer size) {
        importDataService.setDataTotal(id,size);
    }

    @Override
    protected String getBasePath() {
        return basePath;
    }

    @Override
    public void importMicrowave(DiffractionImportDto importDto, Long id, MultipartFile matFile,MultipartFile diffraction, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put("diffraction",diffraction);
        Map<String,MultipartFile> plusFileMap = new HashedMap();
        plusFileMap.put(METLAB_FILE_KEY,matFile);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setPlusMap(plusFileMap);
        fileData.setStruct(null);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(id);
        historyFormDto.setDataForm(importDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.DIFFRACTION);
        importMaterialData(fileData,historyFormDto,importDto);
    }
}
