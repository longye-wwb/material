package com.crledu.auto.material.photon.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.photon.api.vo.PhotonSkyVo;
import com.crledu.auto.material.photon.repository.dto.PhotonSkySelection;
import com.crledu.auto.material.photon.repository.entity.PhotonSkyCount;
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
 * @Date: 2020/9/3
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface PhotonSkyCountMapper extends BaseMapper<PhotonSkyCount> {

    @Select({"<script>",
            "select a.top_type,a.top_constant,a.down_type,a.down_constant,a.source,a.light_type,a.light_angle,a.work_type,b.* FROM at_sky a,at_sky_count b " ,
                    "WHERE a.id = b.sky_id",
            "<when test='photonSkySelection.topType!=null'>AND a.top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND a.top_constant.`user` = #{user}</when>",
            "<when test='photonSkySelection.downType!=null'>AND hr_o_user.`name` like #{name}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND hr_o_user.position like #{position}</when>",
    "</script>"})
    List<PhotonSkyVo>selectSkyList(PhotonSkySelection photonSkySelection);


    @Insert({"<script>",
            "insert into at_sky_count (phase,amplitude,fake,truth,sky_type,start,end,sky_id) values " ,
            "<foreach collection=\"photons\" item=\"photon\" separator=\",\">",
            "(#{photon.phase},#{photon.amplitude},#{photon.fake},#{photon.truth},#{photon.skyType},#{photon.start},#{photon.end},#{photon.skyId})",
            "</foreach>",
            "</script>"})
    void insertBig(@Param("photons") List<PhotonSkyCount> photonSkyCounts);
}
