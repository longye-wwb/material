package com.crledu.auto.material.antenna.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.InfraredPhaseImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.biz.repository.BaseInfraredPhaseImportDataDomainRepository;
import com.crledu.auto.material.antenna.biz.service.BaseInfraredPhaseImportService;
import com.crledu.auto.material.antenna.repository.dao.BaseInfraredParseDao;
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
 * @Description: 红外宽带位相调控服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 15:15
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class InfraredPhaseImportServiceImpl extends AbstractAntennaImportServiceImpl implements BaseInfraredPhaseImportService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseInfraredPhaseImportDataDomainRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseInfraredParseDao dao;


    @Override
    public void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process) {
        baseImportData(DataTypeEnum.INFRARED_PHASE,formdata, creator, struct, realData, emptyData, process);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response, request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.INFRARED_PHASE);
    }

    @Override
    protected void saveDomain(AntennaImportDataDomain domain) {
        if(ObjectUtils.isNotNull(domain)){
            InfraredPhaseImportDataDomain dataDomain = (InfraredPhaseImportDataDomain) domain;
            repository.saveInData(dataDomain);
        }
    }

    @Override
    protected Class getDomainClass() {
        return InfraredPhaseImportDataDomain.class;
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
