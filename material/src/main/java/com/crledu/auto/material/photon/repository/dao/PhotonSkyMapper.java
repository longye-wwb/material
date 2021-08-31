package com.crledu.auto.material.photon.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.photon.api.vo.PhotonSkyVo;
import com.crledu.auto.material.photon.repository.dto.PhotonSkySelection;
import com.crledu.auto.material.photon.repository.entity.PhotonSky;
import com.crledu.auto.material.photon.api.vo.NanoAntennaCircleVo;
import com.crledu.auto.material.photon.api.vo.NanoAntennaColumnVo;
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
public interface PhotonSkyMapper extends BaseMapper<PhotonSky> {

    @Select({"<script>" +
            "select a.top_type,a.top_constant,a.down_type,a.down_constant,a.source,a.light_type,a.light_angle,a.work_type,a.file,b.* from" ,
            "at_sky a,at_sky_count b "+"WHERE a.id = b.sky_id",
            "<when test='photonSkySelection.topType!=null'>AND a.top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND a.top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND a.down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND a.light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND a.light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND a.light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.workType!=null'>AND a.work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.start!=null'>AND b.start = #{photonSkySelection.start}</when>",
            "<when test='photonSkySelection.end!=null'>AND b.end = #{photonSkySelection.end}</when>",
            "<when test='photonSkySelection.source!=null'>AND a.source = #{photonSkySelection.source}</when>",
            "limit #{photonSkySelection.pageNum},#{photonSkySelection.pageSize}",
            "</script>"})
    List<PhotonSkyVo> selectList(@Param("photonSkySelection") PhotonSkySelection photonSkySelection);




    @Select({"<script>" ,
            "select count(*) from at_sky a,at_sky_count b WHERE a.id = b.sky_id",
            "<when test='photonSkySelection.topType!=null'>AND a.top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND a.top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND a.down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND a.light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.workType!=null'>AND a.work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND a.light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND a.light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.start!=null'>AND b.start = #{photonSkySelection.start}</when>",
            "<when test='photonSkySelection.end!=null'>AND b.end = #{photonSkySelection.end}</when>",
            "<when test='photonSkySelection.source!=null'>AND a.source = #{photonSkySelection.source}</when>",
            "</script>"})
    Long selectRows(@Param("photonSkySelection")PhotonSkySelection photonSkySelection);


    @Select({"<script>" ,
            "select a.top_type,a.top_constant,a.down_type,a.down_constant,a.source,a.light_type,a.light_angle,a.work_type,a.file,c.h,c.p,c.min_h,c.r from at_sky a,at_sky_count b,at_sky_circle c WHERE a.id = b.sky_id=c.sky_id",
            "<when test='photonSkySelection.topType!=null'>AND a.top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND a.top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND a.down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND a.light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.workType!=null'>AND a.work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND a.light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND a.light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.start!=null'>AND b.start = #{photonSkySelection.start}</when>",
            "<when test='photonSkySelection.end!=null'>AND b.end = #{photonSkySelection.end}</when>",
            "limit #{photonSkySelection.pageNum},#{photonSkySelection.pageSize}",
            "<when test='photonSkySelection.source!=null'>AND a.source = #{photonSkySelection.source}</when>",
            "</script>"})
    List<NanoAntennaCircleVo> selectCircleList(@Param("photonSkySelection")PhotonSkySelection photonSkySelection);

    @Select({"<script>" ,
            "select a.top_type,a.top_constant,a.down_type,a.down_constant,a.source,a.light_type,a.light_angle,a.work_type,a,file,c.h,c.p,c.min_h,c.x,c.y,c.angle from at_sky a,at_sky_count b,at_sky_circle c WHERE a.id = b.sky_id=c.sky_id",
            "<when test='photonSkySelection.topType!=null'>AND a.top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND a.top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND a.down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND a.down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND a.light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.workType!=null'>AND a.work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND a.light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND a.light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.start!=null'>AND b.start = #{photonSkySelection.start}</when>",
            "<when test='photonSkySelection.end!=null'>AND b.end = #{photonSkySelection.end}</when>",
            "<when test='photonSkySelection.source!=null'>AND a.source = #{photonSkySelection.source}</when>",
            "limit #{photonSkySelection.pageNum},#{photonSkySelection.pageSize}",
            "</script>"})
    List<NanoAntennaColumnVo> selectColumnList(@Param("photonSkySelection")PhotonSkySelection photonSkySelection);



}
