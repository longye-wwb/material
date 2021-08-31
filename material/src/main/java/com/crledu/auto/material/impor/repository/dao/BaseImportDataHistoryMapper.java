package com.crledu.auto.material.impor.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.impor.data.dto.ImportHistoryItemDto;
import com.crledu.auto.material.impor.repository.entity.ImportDataHistoryEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 ************************************************************
 * @Description: 导入数据操作历史数据操作对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/13 9:22
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseImportDataHistoryMapper extends BaseMapper<ImportDataHistoryEntity> {

    @Select({"<script>",
            "select at_import.id,at_import.type,at_import.creator,hr_user.name creator_name,at_import.create_time,at_import.form,at_import.cur_status status",
            "from at_import left join hr_user on at_import.creator = hr_user.id",
            "where 1=1",
            "<when test='before!=null'>and date_format(at_import.create_time,'%Y-%m-%d %H:%i:%s') &lt;= date_format(#{before},'%Y-%m-%d %H:%i:%s')</when>",
            "<when test='after!=null'>and date_format(at_import.create_time,'%Y-%m-%d %H:%i:%s') &gt;= date_format(#{after},'%Y-%m-%d %H:%i:%s')</when>",
            "<when test='type!=null'>and at_import.type =#{type} </when>",
            "</script>"})
    List<ImportHistoryItemDto> selectItemDto(@Param("before") Date before, @Param("after") Date after, @Param("type") Integer type, Page<ImportHistoryItemDto> page);

    @Select({"<script>",
            "select sum(total) from at_import",
            "</script>"})
    Integer sumTotal();
}
