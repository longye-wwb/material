package com.crledu.auto.material.antenna.biz.service.impl;

import com.crledu.auto.material.antenna.biz.domain.AntennaImportDataDomain;
import com.crledu.auto.material.antenna.biz.dto.AntennaImportFormdataDto;
import com.crledu.auto.material.base.dto.ImportHistoryFormDto;
import com.crledu.auto.material.base.dto.ImportItemFileData;
import com.crledu.auto.material.base.service.AbstractImportService;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 ************************************************************
 * @Description: 天线导入公共导入方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/9 14:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public abstract class AbstractAntennaImportServiceImpl extends AbstractImportService<AntennaImportDataDomain> {

    private final String REAL_PART_FILE_NAME = "real";
    private final String EMPTY_PART_FILE_NAME = "empty";

    public void baseImportData(DataTypeEnum type, AntennaImportFormdataDto formdata, Long creator, MultipartFile struct, MultipartFile realData, MultipartFile emptyData, MultipartFile process) {
        Map<String,MultipartFile> dataFileMap = new HashedMap();
        dataFileMap.put(REAL_PART_FILE_NAME,realData);
        dataFileMap.put(EMPTY_PART_FILE_NAME,emptyData);
        ImportItemFileData fileData = new ImportItemFileData();
        fileData.setDataMap(dataFileMap);
        fileData.setStruct(struct);
        ImportHistoryFormDto historyFormDto = new ImportHistoryFormDto();
        historyFormDto.setCreator(creator);
        historyFormDto.setDataForm(formdata.getDataFrom());
        historyFormDto.setProcess(process);
        historyFormDto.setType(type);
        historyFormDto.setImportId(formdata.getImportId());
        importMaterialData(fileData,historyFormDto,formdata);
    }
}
