package com.crledu.auto.material.antenna.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.InfraredAmplitudeImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.biz.repository.BaseInfraredAmplitudeImportDataDomainRepository;
import com.crledu.auto.material.antenna.biz.service.BaseInfraredAmplitudeImportService;
import com.crledu.auto.material.antenna.repository.dao.BaseInfraredAmplitudeDao;
import com.crledu.auto.material.antenna.repository.entity.InfraredAmplitudeEntity;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 红外振幅转换服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 15:26
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredAmplitudeImportServiceImpl extends AbstractAntennaImportServiceImpl implements BaseInfraredAmplitudeImportService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseInfraredAmplitudeImportDataDomainRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseInfraredAmplitudeDao dao;

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.INFRARED_AMPLITUDE);
    }

    @Override
    protected void saveDomain(AntennaImportDataDomain domain) {
        if(ObjectUtils.isNotNull(domain)){
            InfraredAmplitudeImportDataDomain dataDomain = (InfraredAmplitudeImportDataDomain) domain;
            repository.saveInData(dataDomain);
        }
    }

    @Override
    protected Class getDomainClass() {
        return InfraredAmplitudeImportDataDomain.class;
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
    public void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process) {
        baseImportData(DataTypeEnum.INFRARED_AMPLITUDE,formdata, creator, struct, realData, emptyData, process);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
