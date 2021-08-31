package com.crledu.auto.material.infrared.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingVo;
import com.crledu.auto.material.infrared.biz.dto.MicrowaveAbsorbingSelectDto;
import com.crledu.auto.material.infrared.repository.entity.MicrowaveAbsorbingLayerEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收层数据
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/26 18:10
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseMicrowaveAbsorbingLayerDao extends BaseMapper<MicrowaveAbsorbingLayerEntity> {

    @Select({"<script>",
            "SELECT *" ,
            "FROM at_microwave_absorbing",
            "WHERE 1=1",
            "<when test='dto.period!=null'>AND at_microwave_absorbing.period = #{dto.period}</when>",
            "<when test='dto.dataFrom!=null'>AND at_microwave_absorbing.data_from = #{dto.dataFrom}</when>",
            "<when test='dto.lightAngle!=null'>AND at_microwave_absorbing.light_angle = #{dto.lightAngle}</when>",
            "<when test='dto.absorbingData!=null'>AND at_microwave_absorbing.absorbing_data = #{dto.absorbingData}</when>",
            "<when test='dto.curStatus!=null'>AND at_microwave_absorbing.cur_status = #{dto.curStatus}</when>",
            "</script>"})
    List<MicrowaveAbsorbingVo> selectMicrowaveList(@Param("dto") MicrowaveAbsorbingSelectDto selectDto, Page<MicrowaveAbsorbingVo> page);
}
