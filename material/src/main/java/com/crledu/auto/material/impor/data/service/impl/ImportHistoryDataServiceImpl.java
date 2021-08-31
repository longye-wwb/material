package com.crledu.auto.material.impor.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.impor.data.dto.ImportHistoryItemDto;
import com.crledu.auto.material.impor.data.dto.ImportHistorySelectDto;
import com.crledu.auto.material.impor.data.service.BaseImportHistoryDataService;
import com.crledu.auto.material.impor.repository.dao.BaseImportDataHistoryMapper;
import com.crledu.auto.material.impor.repository.entity.ImportDataHistoryEntity;
import com.crledu.auto.util.file.FileUtils;
import com.crledu.auto.util.string.StringUtils;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.vo.date.DateAreaParamVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 ************************************************************
 * @Description: 导入历史数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 14:06
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class ImportHistoryDataServiceImpl implements BaseImportHistoryDataService {

    private final String MATERIAL_FILE_PATH = "material";
    private final String PROCESS_FILE_PATH = "process";

    @Value("${crledu.auto.file.base-path}")
    private String basePath;

    @Resource
    private BaseImportDataHistoryMapper historyMapper;

    @Override
    public PageDate<ImportHistoryItemDto> selectPage(ImportHistorySelectDto selectDto) {
        Page<ImportHistoryItemDto> page = new Page<>(selectDto.getPageNum(),selectDto.getPageSize());
        if(selectDto.getCreateTime() == null){
            selectDto.setCreateTime(new DateAreaParamVo());
        }
        List<ImportHistoryItemDto> rows = historyMapper.selectItemDto(selectDto.getCreateTime().getBefore(),selectDto.getCreateTime().getAfter(),selectDto.getType(),page);
        page.setRecords(rows);
        return new PageDate<>(page);
    }

    @Override
    public File getProcess(Long id) {
        ImportDataHistoryEntity entity = historyMapper.selectById(id);
        if(entity == null){
            return null;
        }else{
            if(StringUtils.isEmpty(entity.getProcess())){
                return null;
            }else{
                return new File(entity.getProcess());
            }
        }
    }

    @Override
    public String ProcessFilesSize() {
        String direction = basePath+ File.separator+ PROCESS_FILE_PATH;
        long size = org.apache.commons.io.FileUtils.sizeOfDirectory(new File(direction));
        String sizeStr = FileUtils.formatFileSize(size);
        return sizeStr;
    }

    @Override
    public String materialFilesSize() {
        String direction = basePath+ File.separator+ MATERIAL_FILE_PATH;
        long size = org.apache.commons.io.FileUtils.sizeOfDirectory(new File(direction));
        String sizeStr = FileUtils.formatFileSize(size);
        return sizeStr;
    }

    @Override
    public Integer countTotal() {
        return historyMapper.sumTotal();
    }
}
