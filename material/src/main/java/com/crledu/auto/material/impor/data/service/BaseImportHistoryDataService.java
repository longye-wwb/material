package com.crledu.auto.material.impor.data.service;

import com.crledu.auto.material.impor.data.dto.ImportHistoryItemDto;
import com.crledu.auto.material.impor.data.dto.ImportHistorySelectDto;
import com.crledu.auto.web.response.PageDate;

import java.io.File;

/**
 ************************************************************
 * @Description: 导入历史数据服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/12/11 11:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseImportHistoryDataService {

    PageDate<ImportHistoryItemDto> selectPage(ImportHistorySelectDto selectDto);

    File getProcess(Long id);

    String ProcessFilesSize();
    String materialFilesSize();
    Integer countTotal();
}
