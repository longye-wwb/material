package com.crledu.auto.material.second.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.second.biz.domain.BoundaryDomain;
import com.crledu.auto.material.second.biz.dto.BoundaryImportDto;
import com.crledu.auto.material.second.biz.repository.BaseBoundaryRepository;
import com.crledu.auto.material.second.biz.service.BaseBoundaryService;
import com.crledu.auto.material.second.repository.dao.BaseBoundaryMapper;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 ************************************************************
 * @Description: 
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 22:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class BoundaryServiceImpl  extends AbstractImportService<BoundaryDomain> implements BaseBoundaryService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseBoundaryRepository repository;

    @Resource
    private BaseBoundaryMapper dao;

    @Override
    public void importData(BoundaryImportDto importDto, Long id, MultipartFile struct, MultipartFile real, MultipartFile empty, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put(STRUCT_FILE_KEY,struct);
        dataFileMap.put("real",real);
        dataFileMap.put("empty",empty);
        ImportItemFileData importItemFileData = new ImportItemFileData();
        importItemFileData.setStruct(struct);
        importItemFileData.setDataMap(dataFileMap);
        ImportHistoryFormDto formDto = new ImportHistoryFormDto();
        formDto.setProcess(process);
        formDto.setDataForm(importDto.getDataFrom());
        formDto.setCreator(id);
        formDto.setType(DataTypeEnum.BOUNDARY);
        importMaterialData(importItemFileData,formDto,importDto);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        ImportDataItemDto result = importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.BOUNDARY);
        return result;
    }

    @Override
    protected void saveDomain(BoundaryDomain domain) {
        repository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return BoundaryDomain.class;
    }

    @Override
    protected void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("id");
        dao.delete(queryWrapper);
    }

    @Override
    protected void setDataTotal(Long id, Integer size) {
        importDataService.setDataTotal(id,size);
    }

    @Override
    protected String getBasePath() {
        return basePath;
    }
}
