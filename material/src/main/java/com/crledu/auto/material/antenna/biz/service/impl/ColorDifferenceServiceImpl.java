package com.crledu.auto.material.antenna.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.domain.ColorDifferenceImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.antenna.biz.repository.BaseColorDifferenceRepository;
import com.crledu.auto.material.antenna.biz.service.BaseColorDifferenceService;
import com.crledu.auto.material.antenna.repository.dao.BaseColorDiffrenceMapper;
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
 * @Description: 消色差结构服务的实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/5/17 15:54
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class ColorDifferenceServiceImpl extends AbstractAntennaImportServiceImpl implements BaseColorDifferenceService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseColorDifferenceRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseColorDiffrenceMapper dao;

    @Override
    public void importData(AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process) {
        baseImportData(DataTypeEnum.COLOR_DIFFERENCE,formdata, creator, struct, realData, emptyData, process);
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.COLOR_DIFFERENCE);
    }

    @Override
    protected void saveDomain(AntennaImportDataDomain domain) {
        if(ObjectUtils.isNotNull(domain)){
            ColorDifferenceImportDataDomain dataDomain = (ColorDifferenceImportDataDomain)domain;
            repository.saveInData(dataDomain);
        }

    }

    @Override
    protected Class getDomainClass() {
        return ColorDifferenceImportDataDomain.class;
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
