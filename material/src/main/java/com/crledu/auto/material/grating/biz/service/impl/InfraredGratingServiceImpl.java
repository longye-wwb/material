package com.crledu.auto.material.grating.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.grating.biz.domain.InfraredGratingDomain;
import com.crledu.auto.material.grating.biz.dto.InfraredGratingFormDataDto;
import com.crledu.auto.material.grating.biz.repository.BaseInfraredGratingDomainRepository;
import com.crledu.auto.material.grating.biz.service.BaseInfraredGratingService;
import com.crledu.auto.material.grating.repository.dao.BaseInfraredGratingMapper;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
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
 * @Description: 红外光栅材料数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/30 18:39
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredGratingServiceImpl  extends AbstractImportService<InfraredGratingDomain> implements BaseInfraredGratingService{

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    private final String ABSOBING_FILE_NAMR = "absorbing";

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseInfraredGratingDomainRepository infraredGratingDomainRepository;

    @Resource
    private BaseInfraredGratingMapper dao;

    @Override
    public void importData(MultipartFile struct, InfraredGratingFormDataDto formDataDto,Long creator,MultipartFile process, MultipartFile absorbing) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put(ABSOBING_FILE_NAMR,absorbing);

        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setStruct(struct);

        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(creator);
        historyFormDto.setDataForm(formDataDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.INFRARED_GRATING);

        importMaterialData(fileData,historyFormDto,formDataDto);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.INFRARED_GRATING);
    }

    @Override
    protected void saveDomain(InfraredGratingDomain domain) {
        infraredGratingDomainRepository.saveInData(domain);

    }

    @Override
    protected Class getDomainClass() {
        return InfraredGratingDomain.class;
    }

    @Override
    protected void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNotNull("id");
        dao.delete(queryWrapper);
    }

    @Override
    protected void setDataTotal(Long id,Integer size) {
        importDataService.setDataTotal(id,size);
    }

    @Override
    protected String getBasePath() {
        return basePath;
    }
}
