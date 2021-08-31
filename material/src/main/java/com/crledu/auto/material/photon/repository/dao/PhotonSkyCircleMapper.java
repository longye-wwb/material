package com.crledu.auto.material.photon.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.photon.repository.entity.PhotonSkyCircle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ***********************************************************
 *
 * @Description: 系统支持的调用方种类。以及调用密匙。
 * @Version: v1.1.1
 * ***********************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: zjs
 * @Date: 2020/9/2
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface PhotonSkyCircleMapper extends BaseMapper<PhotonSkyCircle> {

    @Select("select id from at_sky_circle where sky_id = #{skyId}")
    List<Long> selectIdList(@Param("skyId") Long skyId);


    @Insert({"<script>",
            "insert into at_sky_circle (h,p,min_h,r,sky_id) values " ,
            "<foreach collection=\"photons\" item=\"photon\" separator=\",\">",
            "(#{photon.h},#{photon.p},#{photon.minH},#{photon.r},#{photon.skyId})",
            "</foreach>",
            "</script>"})
    void insertBig(@Param(value = "photons") List<PhotonSkyCircle> circles);
}
