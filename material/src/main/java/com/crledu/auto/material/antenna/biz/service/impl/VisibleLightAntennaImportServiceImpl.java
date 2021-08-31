package com.crledu.auto.material.antenna.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.VisibleLigntAntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.biz.repository.BaseVisibleLigntAntennaImportDataDomainRepository;
import com.crledu.auto.material.antenna.biz.service.BaseVisibleLightAntennaImportService;
import com.crledu.auto.material.antenna.repository.dao.BaseVisibleAntennaDao;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 可见光宽带位相调控
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 15:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class VisibleLightAntennaImportServiceImpl extends AbstractAntennaImportServiceImpl implements BaseVisibleLightAntennaImportService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseVisibleLigntAntennaImportDataDomainRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseVisibleAntennaDao dao;

    @Override
    public void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile phase, MultipartFile amplitude, MultipartFile process) {
        baseImportData(DataTypeEnum.VISIBLE_LIGHT,formdata, creator, struct, phase, amplitude, process);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response, request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.VISIBLE_LIGHT);
    }

    @Override
    protected void saveDomain(AntennaImportDataDomain domain) {
        if(domain != null){
            VisibleLigntAntennaImportDataDomain dataDomain = (VisibleLigntAntennaImportDataDomain)domain;
            repository.saveInData(dataDomain);
        }
    }

    @Override
    protected Class getDomainClass() {
        return VisibleLigntAntennaImportDataDomain.class;
    }

    @Override
    protected void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("id");
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
