package com.crledu.auto.material.microw.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.microw.biz.domain.MicrowavePhaseImportDomain;
import com.crledu.auto.material.microw.biz.dto.MicrowavePhaseImportFormDto;
import com.crledu.auto.material.microw.biz.repository.BaseMicrowavePhaseImportDomainRepository;
import com.crledu.auto.material.microw.biz.service.BaseMicrowavePhaseImportService;
import com.crledu.auto.material.microw.repository.dao.BaseMicrowavePhaseDao;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 ************************************************************
 * @Description: 微波宽带相位调控导入服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/10 17:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class MicrowavePhaseImportServiceImpl extends AbstractImportService<MicrowavePhaseImportDomain> implements BaseMicrowavePhaseImportService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String RANGE_FILE_NAME = "range";

    @Resource
    private BaseMicrowavePhaseImportDomainRepository importDomainRepository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseMicrowavePhaseDao dao;

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.MICRO_PHASE);
    }

    @Override
    protected void saveDomain(MicrowavePhaseImportDomain domain) {
        importDomainRepository.saveInData(domain);

    }

    @Override
    protected Class getDomainClass() {
        return MicrowavePhaseImportDomain.class;
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
    public void importData(MicrowavePhaseImportFormDto formDto, Long creator, MultipartFile struct, MultipartFile range, MultipartFile process) {
        Map<String,MultipartFile> dataMap = new HashMap<>();
        dataMap.put(RANGE_FILE_NAME,range);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataMap);
        fileData.setStruct(struct);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(creator);
        historyFormDto.setDataForm(formDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.MICRO_PHASE);
        importMaterialData(fileData,historyFormDto,formDto);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
