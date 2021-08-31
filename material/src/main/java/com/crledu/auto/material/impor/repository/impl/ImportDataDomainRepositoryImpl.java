package com.crledu.auto.material.impor.repository.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.crledu.auto.material.impor.biz.domain.ImportDataDomain;
import com.crledu.auto.material.impor.biz.repository.BaseImportDataDomainRepository;
import com.crledu.auto.material.impor.repository.dao.BaseImportDataHistoryMapper;
import com.crledu.auto.material.impor.repository.entity.ImportDataHistoryEntity;
import com.crledu.auto.util.ObjectUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 ************************************************************
 * @Description: 导入数据历史仓库实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:58
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class ImportDataDomainRepositoryImpl implements BaseImportDataDomainRepository {

    @Resource
    private BaseImportDataHistoryMapper importDataHistoryMapper;

    @Override
    public ImportDataDomain createWithData(Long id) {
        ImportDataHistoryEntity entity = importDataHistoryMapper.selectById(id);
        if( entity != null){
            JSONObject fileJson = JSON.parseObject(entity.getFiles());
            Set<String> keys =fileJson.keySet();
            Map<String, File> fileMap = new HashedMap();
            for(String item:keys){
                File file = new File(fileJson.getString(item));
                fileMap.put(item,file);
            }
            JSONObject formJson = JSON.parseObject(entity.getForm());
            Set<String> formKeys =formJson.keySet();
            Map<String,Object> formMap = new HashedMap();
            for(String key:formKeys){
                Object obj = formJson.get(key);
                formMap.put(key,obj);
            }
            ImportDataDomain importDataDomain = new ImportDataDomain(entity.getId(),entity.getType(),formMap,fileMap,entity.getCreateTime(),entity.getCreator(),entity.getDataFrom(),entity.getProcess() ==null?null:new File(entity.getProcess()),entity.getCurStatus(),0f);
            return importDataDomain;
        }
        return null;
    }

    @Override
    public ImportDataDomain saveInData(ImportDataDomain domain)
    {
        ImportDataHistoryEntity importDataHistoryEntity = new ImportDataHistoryEntity();
        copyProperties(domain,importDataHistoryEntity);
        importDataHistoryMapper.insert(importDataHistoryEntity);
        return createWithData(importDataHistoryEntity.getId());
    }

    @Override
    public ImportDataDomain updateToData(ImportDataDomain domain) {
        ImportDataHistoryEntity importDataHistoryEntity = importDataHistoryMapper.selectById(domain.getId());
        copyProperties(domain,importDataHistoryEntity);
        importDataHistoryMapper.updateById(importDataHistoryEntity);
        return createWithData(importDataHistoryEntity.getId());
    }

    @Override
    public Boolean deleteFromData(Long id) {
        return null;
    }

    private void copyProperties(ImportDataDomain domain,ImportDataHistoryEntity entity){
        entity.setCreateTime(domain.getCreateTime());
        entity.setCreator(domain.getCreator());
        entity.setCurStatus(domain.getStatus());
        entity.setDataFrom(domain.getDataFrom());
        entity.setFiles(JSON.toJSONString(domain.getFiles()));
        entity.setForm(JSON.toJSONString(domain.getForm()));
        entity.setType(domain.getType());
        entity.setTotal(domain.getDataSize().intValue());
        if (domain.getProcess()!=null) {
            entity.setProcess(domain.getProcess().getPath());
        }
    }

    @Override
    public void setTotal(Long id, Integer total) {
        ImportDataHistoryEntity importDataHistoryEntity = importDataHistoryMapper.selectById(id);
        if(ObjectUtils.isNotNull(importDataHistoryEntity)){
            importDataHistoryEntity.setTotal(total);
            importDataHistoryMapper.updateById(importDataHistoryEntity);
        }
    }
}
