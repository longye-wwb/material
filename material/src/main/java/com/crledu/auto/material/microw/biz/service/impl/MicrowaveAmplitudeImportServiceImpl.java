package com.crledu.auto.material.microw.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.microw.biz.domain.MicrowaveAmplitudeImportDomain;
import com.crledu.auto.material.microw.biz.dto.MicrowaveAmplitudeImportFormDto;
import com.crledu.auto.material.microw.biz.repository.BaseMicrowaveAmplitudeImportDomainRepository;
import com.crledu.auto.material.microw.biz.service.BaseMicrowaveAmplitudeImportService;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowaveAmplitudeDao;
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
 * @Description: 微波宽带偏振转换的服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 14:01
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class MicrowaveAmplitudeImportServiceImpl extends AbstractImportService<MicrowaveAmplitudeImportDomain> implements BaseMicrowaveAmplitudeImportService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String PHASE_X_FILE_NAME = "x";
    private final String PHASE_Y_FILE_NAME = "y";

    @Resource
    private BaseMicrowaveAmplitudeImportDomainRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseMicrowaveAmplitudeDao dao;

    @Override
    public void importData(MicrowaveAmplitudeImportFormDto importFormDto, Long creator, MultipartFile struct, MultipartFile phaseX, MultipartFile phaseY, MultipartFile process) {
        Map<String,MultipartFile> dataFiles = new HashedMap();
        dataFiles.put(PHASE_X_FILE_NAME,phaseX);
        dataFiles.put(PHASE_Y_FILE_NAME,phaseY);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setStruct(struct);
        fileData.setDataMap(dataFiles);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setType(DataTypeEnum.MICRO_AMPLITUDE);
        historyFormDto.setProcess(process);
        historyFormDto.setDataForm(importFormDto.getDataFrom());
        historyFormDto.setCreator(creator);
        importMaterialData(fileData,historyFormDto,importFormDto);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.MICRO_AMPLITUDE);
    }

    @Override
    protected void saveDomain(MicrowaveAmplitudeImportDomain domain) {
        repository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return MicrowaveAmplitudeImportDomain.class;
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
