package com.crledu.auto.material.cooling.biz.service;

import com.crledu.auto.material.cooling.biz.dto.*;
import com.crledu.auto.web.response.PageDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 辐射制冷材料服务
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/16 9:55
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseCoolingMaterailService {

    /**
     *****************************************************************************
     * @Description 导入辐射制冷数据
     *****************************************************************************
     * @Param [importData]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/16 14:06
     *****************************************************************************
     **/
    void importCoolingMaterialData(CoolingMetatailImportDto importData);

    PageDate<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto);

    CoolingMaterialInfoDto findCoolingMaterialInfo(CoolingMaterialAbsorSelectDto selectDto);

    void buildImportTemplate(HttpServletResponse response, HttpServletRequest request) throws IOException;

}
