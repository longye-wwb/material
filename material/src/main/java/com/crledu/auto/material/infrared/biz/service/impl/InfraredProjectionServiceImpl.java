package com.crledu.auto.material.infrared.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.infrared.biz.domain.InfraredProjectionLayerImportDomain;
import com.crledu.auto.material.infrared.biz.dto.InfraredProjectionFormdataDto;
import com.crledu.auto.material.infrared.biz.repository.BaseInfraredProjectionImportDomainRepository;
import com.crledu.auto.material.infrared.biz.service.BaseInfraredProjectionService;
import com.crledu.auto.material.infrared.repository.dao.BaseInfraredProjectionDao;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 ************************************************************
 * @Description: 红外反射微波透射层导入逻辑
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/7 13:53
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredProjectionServiceImpl extends AbstractImportService<InfraredProjectionLayerImportDomain> implements BaseInfraredProjectionService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String PROJECTION_FILE_NAME = "projection";

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseInfraredProjectionImportDomainRepository repository;

    @Resource
    private BaseInfraredProjectionDao dao;


    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.PROJECTION);
    }

    @Override
    protected void saveDomain(InfraredProjectionLayerImportDomain domain) {
        repository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return InfraredProjectionLayerImportDomain.class;
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

    @Override
    public void importData(MultipartFile struct, InfraredProjectionFormdataDto formDataDto, Long creator, MultipartFile process, MultipartFile projection) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put(PROJECTION_FILE_NAME,projection);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setStruct(struct);
        fileData.setDataMap(dataFileMap);
        ImportHistoryFormDto importHistoryFormDto = new ImportHistoryFormDto();
        importHistoryFormDto.setType(DataTypeEnum.PROJECTION);
        importHistoryFormDto.setProcess(process);
        importHistoryFormDto.setDataForm(formDataDto.getDataFrom());
        importHistoryFormDto.setCreator(creator);
        importMaterialData(fileData,importHistoryFormDto,formDataDto);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
