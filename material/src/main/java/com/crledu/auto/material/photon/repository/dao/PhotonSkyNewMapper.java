package com.crledu.auto.material.photon.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.crledu.auto.material.photon.api.vo.PhotonSkyVoNew;
import com.crledu.auto.material.photon.repository.dto.PhotonSkySelectionNew;
import com.crledu.auto.material.photon.repository.entity.PhotonSkyNew;
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
 * @Date: 2020/9/16
 * ***********************************************************
 * @ModifiedBy: [name] on [time]
 * ***********************************************************
 **/
public interface PhotonSkyNewMapper extends BaseMapper<PhotonSkyNew> {

    @Select({"<script>" ,
            "select id,top_type,top_constant,down_type,down_constant,source,light_type,light_angle,work_type,file,h,p,min_h,x,y,r,angle,import_id from at_sky_new",
            "<where>",
            "<when test='photonSkySelection.topType!=null'> and top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.source!=null'>AND source = #{photonSkySelection.source}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.workType!=null'>AND work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.hStart!=null'>AND h &gt; #{photonSkySelection.hStart}</when>",
            "<when test='photonSkySelection.hEnd!=null'>AND h &lt; #{photonSkySelection.hEnd}</when>",
            "<when test='photonSkySelection.pStart!=null'>AND pStart &gt;  #{photonSkySelection.pStart}</when>",
            "<when test='photonSkySelection.pEnd!=null'>AND pEnd &lt; #{photonSkySelection.pEnd}</when>",
            "<when test='photonSkySelection.minHStart!=null'>AND minHStart &gt; #{photonSkySelection.minHStart}</when>",
            "<when test='photonSkySelection.minHEnd!=null'>AND minHEnd &lt; #{photonSkySelection.minHEnd}</when>",
            "<when test='photonSkySelection.xStart!=null'>AND xStart &gt; #{photonSkySelection.xStart}</when>",
            "<when test='photonSkySelection.xEnd!=null'>AND xEnd &lt; #{photonSkySelection.xEnd}</when>",
            "<when test='photonSkySelection.angleStart!=null'>AND angleStart &gt; #{photonSkySelection.angleStart}</when>",
            "<when test='photonSkySelection.angleEnd!=null'>AND angleEnd &lt; #{photonSkySelection.angleEnd}</when>",
            "<when test='photonSkySelection.yStart!=null'>AND yStart &gt; #{photonSkySelection.yStart}</when>",
            "<when test='photonSkySelection.yEnd!=null'>AND yEnd &lt; #{photonSkySelection.yEnd}</when>",
            "<when test='photonSkySelection.rStart!=null'>AND rStart &gt; #{photonSkySelection.rStart}</when>",
            "<when test='photonSkySelection.rEnd!=null'>AND rEnd &lt; #{photonSkySelection.rEnd}</when>",
            "</where>",
            "limit #{photonSkySelection.pageNum},#{photonSkySelection.pageSize}",
            "</script>"})
    List<PhotonSkyVoNew> selectResults(@Param(value ="photonSkySelection" ) PhotonSkySelectionNew photonSkySelectionNew);


    @Insert({"<script>",
            "insert into at_sky_new (id,top_type,top_constant,down_type,down_constant,source,light_type,light_angle,work_type,file,h,p,min_h,x,y,r,angle,start_l,end_l) values " ,
            "<foreach collection=\"photons\" item=\"photon\" separator=\",\">",
            "(#{photon.id},#{photon.topType},#{photon.topConstant},#{photon.downType},#{photon.downConstant},#{photon.source},#{photon.lightType},#{photon.lightAngle},#{photon.workType},#{photon.file},#{photon.h},#{photon.p},#{photon.minH},#{photon.x},#{photon.y},#{photon.r},#{photon.angle},#{photon.startL},#{photon.endL})",
            "</foreach>",
            "</script>"})
    void insertBig(@Param(value = "photons") List<PhotonSkyNew> skyNews);


    @Select({"<script>" ,
            "select count(*) from at_sky_new",
            "<where>",
            "<when test='photonSkySelection.topType!=null'>AND top_type = #{photonSkySelection.topType}</when>",
            "<when test='photonSkySelection.topConstant!=null'>AND top_constant = #{photonSkySelection.topConstant}</when>",
            "<when test='photonSkySelection.downType!=null'>AND down_type = #{photonSkySelection.downType}</when>",
            "<when test='photonSkySelection.downConstant!=null'>AND down_constant = #{photonSkySelection.downConstant}</when>",
            "<when test='photonSkySelection.source!=null'>AND down_constant = #{photonSkySelection.source}</when>",
            "<when test='photonSkySelection.lightType!=null'>AND light_type = #{photonSkySelection.lightType}</when>",
            "<when test='photonSkySelection.workType!=null'>AND work_type = #{photonSkySelection.workType}</when>",
            "<when test='photonSkySelection.lightAngleStart!=null'>AND light_angle &gt;= #{photonSkySelection.lightAngleStart}</when>",
            "<when test='photonSkySelection.lightAngleEnd!=null'>AND light_angle &lt;= #{photonSkySelection.lightAngleEnd}</when>",
            "<when test='photonSkySelection.hStart!=null'>AND h &gt; #{photonSkySelection.hStart}</when>",
            "<when test='photonSkySelection.hEnd!=null'>AND h &lt; #{photonSkySelection.hEnd}</when>",
            "<when test='photonSkySelection.pStart!=null'>AND pStart &gt;  #{photonSkySelection.pStart}</when>",
            "<when test='photonSkySelection.pEnd!=null'>AND pEnd &lt; #{photonSkySelection.pEnd}</when>",
            "<when test='photonSkySelection.minHStart!=null'>AND minHStart &gt; #{photonSkySelection.minHStart}</when>",
            "<when test='photonSkySelection.minHEnd!=null'>AND minHEnd &lt; #{photonSkySelection.minHEnd}</when>",
            "<when test='photonSkySelection.xStart!=null'>AND xStart &gt; #{photonSkySelection.xStart}</when>",
            "<when test='photonSkySelection.xEnd!=null'>AND xEnd &lt; #{photonSkySelection.xEnd}</when>",
            "<when test='photonSkySelection.angleStart!=null'>AND angleStart &gt; #{photonSkySelection.angleStart}</when>",
            "<when test='photonSkySelection.angleEnd!=null'>AND angleEnd &lt; #{photonSkySelection.angleEnd}</when>",
            "<when test='photonSkySelection.yStart!=null'>AND yStart &gt; #{photonSkySelection.yStart}</when>",
            "<when test='photonSkySelection.yEnd!=null'>AND yEnd &lt; #{photonSkySelection.yEnd}</when>",
            "<when test='photonSkySelection.rStart!=null'>AND rStart &gt; #{photonSkySelection.rStart}</when>",
            "<when test='photonSkySelection.rEnd!=null'>AND rEnd &lt; #{photonSkySelection.rEnd}</when>",
            "</where>",
            "</script>"})
    Long selectTotal(@Param(value ="photonSkySelection") PhotonSkySelectionNew photonSkySelectionNew);

    @Select("select count(id) from at_sky_new")
    int selectMaxId();
}
