package com.crledu.auto.material.impor.biz.service;

import com.crledu.auto.material.impor.biz.dto.ImportDataCreateDto;
import com.crledu.auto.material.impor.biz.dto.ImportDataItemDto;
import com.crledu.auto.material.system.biz.domain.DataTypeEnum;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 导入数据历史记录相关服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/18 17:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseImportDataService {

    /**
     *****************************************************************************
     * @Description 保存导入数据到历史库
     *****************************************************************************
     * @Param [createDto]
     * @return com.crledu.auto.material.impor.biz.dto.ImportDataItemDto
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/20 9:59
     *****************************************************************************
     **/
    ImportDataItemDto saveInHistory(ImportDataCreateDto createDto, DataTypeEnum typeEnum);

    void setDataTotal(Long importId,Integer total);

    String savePictrue(BufferedImage image, Long importId,String name) throws IOException;
}
