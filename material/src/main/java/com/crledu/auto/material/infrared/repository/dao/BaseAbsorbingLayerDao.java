package com.crledu.auto.material.infrared.repository.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.infrared.api.vo.MicrowaveAbsorbingLayerVo;
import com.crledu.auto.material.infrared.repository.entity.AbsorbingLayerEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 ************************************************************
 * @Description: 微波吸收层组成单元dao
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/26 18:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseAbsorbingLayerDao extends BaseMapper<AbsorbingLayerEntity> {


    @Select("select * from at_ma_layer where ord =#{id}")
    List<MicrowaveAbsorbingLayerVo> selectVoList(@Param("id") Long id);
}
