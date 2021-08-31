package com.crledu.auto.material.infrared.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.infrared.api.vo.ProjectionVo;
import com.crledu.auto.material.infrared.biz.dto.ProjectionDataItemDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionLayerImportDto;
import com.crledu.auto.material.infrared.biz.dto.ProjectionSelectDto;
import com.crledu.auto.material.infrared.repository.entity.ProjectionLayerEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波透射层数据操作
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/26 18:10
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseProjectionLayerDao extends BaseMapper<ProjectionLayerEntity> {

    @Select({"<script>",
            "SELECT *" ,
            "FROM at_projection_mate",
            "WHERE 1=1",
            "<when test='dto.baseMaterial!=null'>AND at_projection_mate.base_material = #{dto.baseMaterial}</when>",
            "<when test='dto.baseDielectric!=null'>AND at_projection_mate.base_dielectric = #{dto.baseDielectric}</when>",
            "<when test='dto.baseEmissivity!=null'>AND at_projection_mate.base_emissivity = #{dto.baseEmissivity}</when>",
            "<when test='dto.dielectricMaterial!=null'>AND at_projection_mate.dielectric_material = #{dto.dielectricMaterial}</when>",
            "<when test='dto.dielectricConstant!=null'>AND at_projection_mate.dielectric_constant = #{dto.dielectricConstant}</when>",
            "<when test='dto.dielectricThickness!=null'>AND at_projection_mate.dielectric_thickness = #{dto.dielectricThickness}</when>",
            "<when test='dto.dielectricEmissivity!=null'>AND at_projection_mate.dielectric_emissivity = #{dto.dielectricEmissivity}</when>",
            "<when test='dto.patchMaterial!=null'>AND at_projection_mate.patch_material = #{dto.patchMaterial}</when>",
            "<when test='dto.patchEmissivity!=null'>AND at_projection_mate.patch_emissivity = #{dto.patchEmissivity}</when>",
            "<when test='dto.patchPeriod!=null'>AND at_projection_mate.patch_period = #{dto.patchPeriod}</when>",
            "<when test='dto.patchWidth!=null'>AND at_projection_mate.patch_width = #{dto.patchWidth}</when>",
            "<when test='dto.patchPercent!=null'>AND at_projection_mate.patch_percent = #{dto.patchPercent}</when>",
            "<when test='dto.emissivity!=null'>AND at_projection_mate.emissivity = #{dto.emissivity}</when>",
            "<when test='dto.lightAngle!=null'>AND at_projection_mate.light_angle = #{dto.lightAngle}</when>",
            "<when test='dto.dataFrom!=null'>AND at_projection_mate.data_from = #{dto.dataFrom}</when>",
            "<when test='dto.projectionData!=null'>AND at_projection_mate.projection_data = #{dto.projectionData}</when>",
            "<when test='dto.curStatus!=null'>AND at_projection_mate.cur_status = #{dto.curStatus}</when>",
            "</script>"})
    List<ProjectionVo> selectProjectionList(@Param(value = "dto") ProjectionSelectDto dto, Page<ProjectionVo> page);
}
