package com.crledu.auto.material.microwave.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.breath.api.vo.BreadthListVo;
import com.crledu.auto.material.breath.repository.dao.BreadthMapper;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.microwave.api.vo.MicrowaveInfoVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveListVo;
import com.crledu.auto.material.microwave.api.vo.MicrowaveSelectVo;
import com.crledu.auto.material.microwave.biz.domain.MicrowaveAbsorbingDomain;
import com.crledu.auto.material.microwave.biz.dto.MicrowaveImportDto;
import com.crledu.auto.material.microwave.biz.repository.MicrowaveRepository;
import com.crledu.auto.material.microwave.biz.service.MicrowaveAbsorbService;
import com.crledu.auto.material.microwave.repository.dao.MicrowaveBroadbandMapper;
import com.crledu.auto.material.microwave.repository.entity.MicrowaveAbsorbEntity;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.util.web.StringParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Date: 2020/12/10
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Service
public class MicrowaveAbsorbServiceImpl extends AbstractImportService<MicrowaveAbsorbingDomain> implements MicrowaveAbsorbService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private MicrowaveRepository microwaveRepository;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private MicrowaveBroadbandMapper mapper;

    @Resource
    private BaseCounterService counterService;

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.MICROWAVE_ABSORBING);
    }

    @Override
    protected void saveDomain(MicrowaveAbsorbingDomain domain) {
        microwaveRepository.saveInData(domain);
    }

    @Override
    protected Class getDomainClass() {
        return MicrowaveAbsorbingDomain.class;
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
    public void importMicrowave(MicrowaveImportDto importDto, Long id, MultipartFile structure, MultipartFile microwave, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put("microwave",microwave);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setStruct(structure);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(id);
        historyFormDto.setDataForm(importDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.MICROWAVE_ABSORBING);
        importMaterialData(fileData,historyFormDto,importDto);
    }

    @Override
    public PageDate<MicrowaveListVo> selectMicrowave(MicrowaveSelectVo paramVo) {
        counterService.addVisiter(DataTypeEnum.MICROWAVE_ABSORBING);
        Page<MicrowaveAbsorbEntity> page = new Page<>(paramVo.getPageNum(),paramVo.getPageSize());
        QueryWrapper<MicrowaveAbsorbEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getEndWave(),"end_wave");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getG(),"g");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH1(),"h1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH2(),"h2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getH3(),"h3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getP(),"p");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS1(),"s1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS2(),"s2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getS3(),"s3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getRs1(),"rs1");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getRs2(),"rs2");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getRs3(),"rs3");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getTotalThickness(),"total_thickness");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getLightAngle(),"light_angle");
        queryWrapper.eq(paramVo.getMaterialStructure()!=null,"material_structure",paramVo.getMaterialStructure());
        queryWrapper.eq(paramVo.getFiller()!=null,"filler",paramVo.getFiller());
        queryWrapper.eq(paramVo.getLayer()!=null,"layer",paramVo.getLayer());
        queryWrapper.eq(paramVo.getDataFrom()!=null,"data_from",paramVo.getDataFrom());
        queryWrapper.eq(paramVo.getLightType()!=null,"light_type",paramVo.getLightType());
        queryWrapper.eq(paramVo.getWorkType()!=null,"work_type",paramVo.getWorkType());
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getBandwidth(),"bandwidth");

        page = mapper.selectPage(page,queryWrapper);
        if(ObjectUtils.isNotNull(page.getRecords())){
            List<MicrowaveListVo> rows = new ArrayList<>();
            for(MicrowaveAbsorbEntity entity:page.getRecords()){
                MicrowaveListVo itemDto = new MicrowaveListVo();
                itemDto.setDataFrom(entity.getDataFrom());
                itemDto.setMaterialStructure(entity.getMaterialStructure());
                itemDto.setId(entity.getId());
                itemDto.setEndWave(entity.getEndWave());
                itemDto.setLightAngle(entity.getLightAngle());
                itemDto.setFiller(entity.getFiller());
                itemDto.setG(entity.getG());
                itemDto.setH1(entity.getH1());
                itemDto.setH2(entity.getH2());
                itemDto.setH3(entity.getH3());
                itemDto.setImportId(entity.getImportId());
                itemDto.setLayer(entity.getLayer());
                itemDto.setLightAngle(entity.getLightAngle());
                itemDto.setLightType(entity.getLightType());
                itemDto.setP(entity.getP());
                itemDto.setRs1(entity.getRs1());
                itemDto.setRs2(entity.getRs2());
                itemDto.setRs3(entity.getRs3());
                itemDto.setS1(entity.getS1());
                itemDto.setS2(entity.getS2());
                itemDto.setS3(entity.getS3());
                itemDto.setStartWave(entity.getStartWave());
                itemDto.setTotalThickness(entity.getTotalThickness());
                itemDto.setWorkType(entity.getWorkType());
                itemDto.setBandwidth(entity.getBandwidth());
                rows.add(itemDto);
            }
            PageDate<MicrowaveListVo> result = new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
            return result;
        }else {
            return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()), IntegerUtils.LongNumberIntegerValue(page.getCurrent()),new ArrayList<>());
        }
    }

    @Override
    public MicrowaveInfoVo selectMicrowaveInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.MICROWAVE_ABSORBING);
        MicrowaveAbsorbEntity entity = mapper.selectById(id);
        String dataFile = baseBigdataRepositoryService.getDataFile(entity.getData());
        MicrowaveInfoVo infoVo = new MicrowaveInfoVo();
        infoVo.setAbsorptionRateDtos(JSONObject.parseObject(dataFile));
        infoVo.setDataFrom(entity.getDataFrom());
        infoVo.setEndWave(entity.getEndWave());
        infoVo.setFiller(entity.getFiller());
        infoVo.setG(entity.getG());
        infoVo.setH1(entity.getH1());
        infoVo.setH2(entity.getH2());
        infoVo.setH3(entity.getH3());
        infoVo.setId(entity.getId());
        infoVo.setImportId(entity.getImportId());
        infoVo.setLayer(entity.getLayer());
        infoVo.setLightAngle(entity.getLightAngle());
        infoVo.setLightType(entity.getLightType());
        infoVo.setP(entity.getP());
        infoVo.setMaterialStructure(entity.getMaterialStructure());
        infoVo.setRs1(entity.getRs1());
        infoVo.setRs2(entity.getRs2());
        infoVo.setRs3(entity.getRs3());
        infoVo.setS1(entity.getS1());
        infoVo.setS2(entity.getS2());
        infoVo.setS3(entity.getS3());
        infoVo.setStartWave(entity.getStartWave());
        infoVo.setTotalThickness(entity.getTotalThickness());
        infoVo.setWorkType(entity.getWorkType());
        infoVo.setBandwidth(entity.getBandwidth());
        return infoVo;
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
