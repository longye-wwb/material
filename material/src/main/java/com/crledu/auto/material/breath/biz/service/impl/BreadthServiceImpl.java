package com.crledu.auto.material.breath.biz.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.bigdata.biz.service.BaseBigdataRepositoryService;
import com.crledu.auto.material.breath.api.vo.BreadthInfoVo;
import com.crledu.auto.material.breath.api.vo.BreadthListVo;
import com.crledu.auto.material.breath.api.vo.BreadthSelectListVo;
import com.crledu.auto.material.breath.biz.domain.BreadthDomain;
import com.crledu.auto.material.breath.biz.dto.BreadthImpotDto;
import com.crledu.auto.material.breath.biz.repository.BreadthRepository;
import com.crledu.auto.material.breath.biz.service.BreadthService;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.breath.repository.dao.BreadthMapper;
import com.crledu.auto.material.breath.repository.entity.BreadthEntity;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.impor.biz.service.BaseImportDataService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import com.crledu.auto.material.system.biz.service.BaseCounterService;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.number.IntegerUtils;
import com.crledu.auto.util.web.NumberParamQueryWrapperUtils;
import com.crledu.auto.util.web.StringParamQueryWrapperUtils;
import com.crledu.auto.web.response.PageDate;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
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
 * @Date: 2020/12/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
@Service
public class BreadthServiceImpl  extends AbstractImportService<BreadthDomain> implements BreadthService {

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataService importDataService;

    @Resource
    private BreadthRepository repository;

    @Resource
    private BreadthMapper breadthMapper;

    @Resource
    private BaseBigdataRepositoryService baseBigdataRepositoryService;

    @Resource
    private BaseCounterService counterService;

    @Override
    public void importBreadth(BreadthImpotDto impotDto, Long id, MultipartFile structure, MultipartFile curve, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put("curve",curve);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setStruct(structure);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(id);
        historyFormDto.setDataForm(impotDto.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(DataTypeEnum.MICRO_BREADTH);
        importMaterialData(fileData,historyFormDto,impotDto);
    }

    @Override
    protected ImportDataItemDto saveIntoHistory(ImportDataCreateDto importDataCreateDto) {
        return importDataService.saveInHistory(importDataCreateDto, DataTypeEnum.MICRO_BREADTH);
    }

    @Override
    protected void saveDomain(BreadthDomain domain) {
        repository.saveIndata(domain);
    }

    @Override
    protected Class getDomainClass() {
        return BreadthDomain.class;
    }

    @Override
    protected void emptyTable() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.isNull("id");
        breadthMapper.delete(queryWrapper);
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
    public PageDate<BreadthListVo> selectBreadthList(BreadthSelectListVo paramVo) {
        counterService.addVisiter(DataTypeEnum.MICRO_BREADTH);
        Page<BreadthEntity> page = new Page<>(paramVo.getPageNum(),paramVo.getPageSize());
        QueryWrapper<BreadthEntity> queryWrapper = new QueryWrapper<>();
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getBaseThickness(),"base_thickness");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getLightAngle(),"light_angle");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getDielectric(),"dielectric");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getLoss(),"loss");
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getStructureThickness(),"structure_thickness");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,paramVo.getBaseMaterial(),"base_material");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,paramVo.getMediumMaterial(),"medium_material");
        StringParamQueryWrapperUtils.buildStringQueryWrapper(queryWrapper,paramVo.getStructureMaterial(),"structure_material");
        queryWrapper.eq(ObjectUtils.isNotNull(paramVo.getType()),"type",paramVo.getType());
        queryWrapper.eq(ObjectUtils.isNotNull(paramVo.getLightType()),"light_type",paramVo.getLightType());
        queryWrapper.eq(ObjectUtils.isNotNull(paramVo.getWorkMode()),"work_mode",paramVo.getWorkMode());
        NumberParamQueryWrapperUtils.buildQueryWrapper(queryWrapper,paramVo.getBandwidth(),"bandwidth");
        page = breadthMapper.selectPage(page,queryWrapper);
        if(ObjectUtils.isNotNull(page.getRecords())){
            List<BreadthListVo> rows = new ArrayList<>();
            for(BreadthEntity entity:page.getRecords()){
                BreadthListVo itemDto = new BreadthListVo();
                itemDto.setDataFrom(entity.getDataFrom());
                itemDto.setBaseMaterial(entity.getBaseMaterial());
                itemDto.setId(entity.getId());
                itemDto.setBaseThickness(entity.getBaseThickness());
                itemDto.setLightAngle(entity.getLightAngle());
                itemDto.setDielectric(entity.getDielectric());
                itemDto.setLoss(entity.getLoss());
                itemDto.setMediumMaterial(entity.getMediumMaterial());
                itemDto.setStructureMaterial(entity.getStructureMaterial());
                itemDto.setStructureThickness(entity.getStructureThickness());
                itemDto.setType(entity.getType());
                itemDto.setPeriod(entity.getPeriod());
                itemDto.setLength(entity.getLength());
                itemDto.setWidth(entity.getWidth());
                itemDto.setWorkingBand(entity.getWorkingBand());
                itemDto.setImportId(entity.getImportId());
                itemDto.setLightType(entity.getLightType());
                itemDto.setWorkMode(entity.getWorkMode());
                itemDto.setBandwidth(entity.getBandwidth());
                BeanUtils.copyProperties(entity,itemDto);

                rows.add(itemDto);
            }
            PageDate<BreadthListVo> result = new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),rows);
            return result;
        }else {
            return new PageDate<>(page.getTotal(), IntegerUtils.LongNumberIntegerValue(page.getSize()),IntegerUtils.LongNumberIntegerValue(page.getCurrent()),new ArrayList<>());
        }
    }

    @Override
    public BreadthInfoVo selectBreadthInfo(Long id) {
        counterService.addVisiter(DataTypeEnum.MICRO_BREADTH);
        BreadthEntity entity = breadthMapper.selectById(id);
        BreadthInfoVo infoVo = new BreadthInfoVo();
        String dataFile = baseBigdataRepositoryService.getDataFile(entity.getData());
        infoVo.setBaseMaterial(entity.getBaseMaterial());
        infoVo.setBaseThickness(entity.getBaseThickness());
        infoVo.setDataFrom(entity.getDataFrom());
        infoVo.setDielectric(entity.getDielectric());
        infoVo.setId(entity.getId());
        infoVo.setLength(entity.getLength());
        infoVo.setLightAngle(entity.getLightAngle());
        infoVo.setLoss(entity.getLoss());
        infoVo.setMediumMaterial(entity.getMediumMaterial());
        infoVo.setMediumThickness(entity.getMediumThickness());
        infoVo.setPeriod(entity.getPeriod());
        infoVo.setStructureMaterial(entity.getStructureMaterial());
        infoVo.setStructureThickness(entity.getStructureThickness());
        infoVo.setType(entity.getType());
        infoVo.setWaveDtos(JSONObject.parseObject(dataFile));
        infoVo.setWorkingBand(entity.getWorkingBand());
        infoVo.setWidth(entity.getWidth());
        infoVo.setImportId(entity.getImportId());
        infoVo.setLightType(entity.getLightType());
        infoVo.setWorkMode(entity.getWorkMode());
        infoVo.setBandwidth(entity.getBandwidth());
        return infoVo;
    }

    @Override
    public void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException {
        buildTemplateFile(response,request);
    }
}
