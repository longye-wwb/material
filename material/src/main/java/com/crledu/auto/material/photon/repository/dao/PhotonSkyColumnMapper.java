package com.crledu.auto.material.photon.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.photon.repository.entity.PhotonSkyColumn;
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
public interface PhotonSkyColumnMapper extends BaseMapper<PhotonSkyColumn> {

    @Select("select id from at_sky_column where sky_id = #{skyId}")
    List<Long> selectIdList(@Param("skyId") Long skyId);


    @Insert({"<script>",
            "insert into at_sky_column (h,p,min_h,x,y,angle,sky_id) values " ,
            "<foreach collection=\"photons\" item=\"photon\" separator=\",\">",
            "(#{photon.h},#{photon.p},#{photon.minH},#{photon.x},#{photon.y},#{photon.angle},#{photon.skyId})",
            "</foreach>",
            "</script>"})
    void insertBig(@Param("photons") List<PhotonSkyColumn> columns);
}
