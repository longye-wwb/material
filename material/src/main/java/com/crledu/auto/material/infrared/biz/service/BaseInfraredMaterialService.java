package com.crledu.auto.material.infrared.biz.service;

import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingVo;
import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.dto.MicrowaveAbsorbingLayerImportDto;
import com.crledu.auto.material.infrared.biz.dto.MicrowaveAbsorbingSelectDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionLayerImportDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionSelectDto;
import com.crledu.auto.web.response.PageDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 微波红外兼容材料service
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/17 16:19
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseInfraredMaterialService {

    /**
     *****************************************************************************
     * @Description 微波透射层数据导入
     *****************************************************************************
     * @Param [importDto]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/11/23 13:51
     *****************************************************************************
     **/
    void saveProjectionData(ProjectionLayerImportDto importDto);
    void saveMicrowaveAbsorbingData(MicrowaveAbsorbingLayerImportDto importDto);

    PageDate<ProjectionVo> selectProjectionList(ProjectionSelectDto projectionSelectDto);

    ProjectionVo selectProjectionInfo(Long id);

    void buildProjectionTemplateFile(HttpServletResponse response, HttpServletRequest request) throws IOException;

    void buildMicrowaveAbsorbingTemplateFile(HttpServletResponse response, HttpServletRequest request) throws IOException;

    PageDate<MicrowaveAbsorbingVo> selectAbsorbingList(MicrowaveAbsorbingSelectDto selectDto);

    MicrowaveAbsorbingVo selectAbsorbingInfo(Long id);
}
