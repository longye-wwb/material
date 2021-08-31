package com.crledu.auto.material.microwaveIntegration.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.microwave.api.vo.MicrowaveInfoVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveListVo;
import com.crledu.auto.material.microwave.repository.entity.MicrowaveAbsorbEntity;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationImportVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationInfoVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationListVo;
import com.crledu.auto.material.microwaveIntegration.api.vo.MicrowaveIntegrationSelectVo;
import com.crledu.auto.material.microwaveIntegration.biz.domain.MicrowaveInterationDomain;
import com.crledu.auto.material.microwaveIntegration.biz.dto.MicrowaveIntegrationImportDto;
import com.crledu.auto.material.microwaveIntegration.biz.repository.MicrowaveIntegrationRepository;
import com.crledu.auto.material.microwaveIntegration.biz.service.MicrowaveIntegrationService;
import com.crledu.auto.material.microwaveIntegration.repository.dao.MicrowaveIntegrationMapper;
import com.crledu.auto.material.microwaveIntegration.repository.entity.MicrowaveIntegrationEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/12/11
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Service
public class MicrowaveIntegrationServiceImpl extends AbstractImportService<MicrowaveInterationDomain> implements MicrowaveIntegrationService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private MicrowaveIntegrationRepository repository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private MicrowaveIntegrationMapper mapper;

    @Resource
    private BaseCounterService counterService;

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.MICRO_INTEGRATION);
    }

    @Override
    protected void saveDomain(MicrowaveInterationDomain domain) {
        repository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return MicrowaveInterationDomain.class;
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
    public void importIntegretion(MicrowaveIntegrationImportDto importDto, Long id, MultipartFile structure, MultipartFile broadband, MultipartFile narrowband, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put("broadband",broadband);
        dataFileMap.put("narrowband",narrowband);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setStruct(structure);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(id);
        historyFormDto.setDataForm(importDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.MICRO_INTEGRATION);
        importMaterialData(fileData,historyFormDto,importDto);
    }

    @Override
    public PageDate<MicrowaveIntegrationListVo> selectMicrowave(MicrowaveIntegrationSelectVo paramVo) {
        counterService.addVisiter(DataTypeEnum.MICRO_INTEGRATION);
        Page<MicrowaveIntegrationEntity> page = new Page<>(paramVo.getPageNum(),paramVo.getPageSize());
        QueryWrapper<MicrowaveIntegrationEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getDielectric(),"dielectric");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getEndFrequency(),"end_frequency");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getG(),"g");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getG0(),"g0");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH(),"h");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH1(),"h1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH2(),"h2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH3(),"h3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getL(),"l");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getL0(),"l0");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getP(),"p");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getR(),"r");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getR1(),"r1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getR2(),"r2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getR3(),"r3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS(),"s");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS1(),"s1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS2(),"s2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS3(),"s3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.gettBandwidth(),"t_bandwidth");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getaBandwidth(),"a_bandwidth");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getStartFrequency(),"start_frequency");
        queryWrapper.eq(paramVo.getDataFrom()!=null,"data_from",paramVo.getDataFrom());
        queryWrapper.eq(paramVo.getLightType()!=null,"light_type",paramVo.getLightType());
        queryWrapper.eq(paramVo.getWorkType()!=null,"work_type",paramVo.getWorkType());
        page = mapper.selectPage(page,queryWrapper);
        if(ObjectUtils.isNotNull(page.getRecords())){
            List<MicrowaveIntegrationListVo> rows = new ArrayList<>();
            for(MicrowaveIntegrationEntity entity:page.getRecords()){
                MicrowaveIntegrationListVo itemDto = new MicrowaveIntegrationListVo();
                itemDto.setDataFrom(entity.getDataFrom());
                itemDto.setId(entity.getId());
                itemDto.setH(entity.getH());
                itemDto.setH1(entity.getH1());
                itemDto.setH2(entity.getH2());
                itemDto.setH3(entity.getH3());
                itemDto.setR(entity.getR());
                itemDto.setR1(entity.getR1());
                itemDto.setR2(entity.getR2());
                itemDto.setR3(entity.getR3());
                itemDto.setG(entity.getG());
                itemDto.setG0(entity.getG0());
                itemDto.setL(entity.getL());
                itemDto.setL0(entity.getL0());
                itemDto.setP(entity.getP());
                itemDto.setStartFrequency(entity.getStartFrequency());
                itemDto.setEndFrequency(entity.getEndFrequency());
                itemDto.setImportId(entity.getImportId());
                itemDto.setLightAngle(entity.getLightAngle());
                itemDto.setLightType(entity.getLightType());
                itemDto.setP(entity.getP());
                itemDto.setS1(entity.getS1());
                itemDto.setS2(entity.getS2());
                itemDto.setS3(entity.getS3());
                itemDto.settBandwidth(entity.gettBandwidth());
                itemDto.setaBandwidth(entity.getaBandwidth());
                itemDto.setWorkType(entity.getWorkType());
                rows.add(itemDto);
            }
            PageDate<MicrowaveIntegrationListVo> result = new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
            return result;
        }else {
            return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()), IntegerUtils.LongNumberIntegerValue(page.getCurrent()),new ArrayList<>());
        }
    }

    @Override
    public MicrowaveIntegrationInfoVo selectMicrowaveInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.MICRO_INTEGRATION);
        MicrowaveIntegrationEntity entity = mapper.selectById(id);
        String dataFile = baseBigdataRepositoryService.getDataFile(entity.getData());
        MicrowaveIntegrationInfoVo infoVo = new MicrowaveIntegrationInfoVo();
        infoVo.setDataFrom(entity.getDataFrom());
        infoVo.setDielectric(entity.getDielectric());
        infoVo.setEndFrequency(entity.getEndFrequency());
        infoVo.setG(entity.getG());
        infoVo.setG0(entity.getG0());
        infoVo.setH(entity.getH());
        infoVo.setH1(entity.getH1());
        infoVo.setH2(entity.getH2());
        infoVo.setH3(entity.getH3());
        infoVo.setId(entity.getId());
        infoVo.setImportId(entity.getImportId());
        infoVo.setIntegration(JSONObject.parseObject(dataFile));
        infoVo.setL(entity.getL());
        infoVo.setL0(entity.getL0());
        infoVo.setLightAngle(entity.getLightAngle());
        infoVo.setLightType(entity.getLightType());
        infoVo.setP(entity.getP());
        infoVo.setR(entity.getR());
        infoVo.setR1(entity.getR1());
        infoVo.setR2(entity.getR2());
        infoVo.setR3(entity.getR3());
        infoVo.setS(entity.getS());
        infoVo.setS1(entity.getS1());
        infoVo.setS2(entity.getS2());
        infoVo.setS3(entity.getS3());
        infoVo.setStartFrequency(entity.getStartFrequency());
        infoVo.setWorkType(entity.getWorkType());
        infoVo.settBandwidth(entity.gettBandwidth());
        infoVo.setaBandwidth(entity.getaBandwidth());
        return infoVo;
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
