package com.crledu.auto.material.cooling.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialItemDto;
import com.crledu.auto.material.cooling.biz.dto.CoolingMaterialSelectDto;
import com.crledu.auto.material.cooling.repository.entity.CoolingMaterailEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BaseCoolingMaterailMapper extends BaseMapper<CoolingMaterailEntity> {

    @Select({"<script>",
            "SELECT *" ,
            "FROM at_cooling_mate",
            "WHERE 1=1",
            "<when test='type!=null'>AND at_cooling_mate.type = #{type}</when>",
            "<when test='baseMaterial!=null'>AND at_cooling_mate.base_material = #{baseMaterial}</when>",
            "<when test='firstMaterial!=null'>AND at_cooling_mate.first_material = #{firstMaterial}</when>",
            "<when test='secondMaterial!=null'>AND at_cooling_mate.second_material = #{secondMaterial}</when>",
            "<when test='thickness!=null'>AND at_cooling_mate.thickness = #{thickness}</when>",
            "<when test='layers!=null'>AND at_cooling_mate.layer_amount = #{layers}</when>",
            "<when test='lightType!=null'>AND at_cooling_mate.light_type = #{lightType}</when>",
            "<when test='lightAngle!=null'>AND at_cooling_mate.light_angle = #{lightAngle}</when>",
            "<when test='workingMode!=null'>AND at_cooling_mate.working_mode = #{workingMode}</when>",
            "<when test='dataFrom!=null'>AND at_cooling_mate.data_from = #{dataFrom}</when>",
            "</script>"})
    List<CoolingMaterialItemDto> selectCoolingMaterial(CoolingMaterialSelectDto selectDto, Page<CoolingMaterialItemDto> page);
}
