package com.crledu.auto.material.user.repository.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.material.user.biz.dto.UserItemDto;
import com.crledu.auto.material.user.repository.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 ************************************************************
 * @Description: 用户数据操作对象
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 17:18
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseUserMapper extends BaseMapper<UserEntity> {

    @Select({"<script>",
            "SELECT *" ,
            "FROM hr_user",
            "WHERE 1=1",
            "<when test='name!=null'>AND hr_user.name like #{name}</when>",
            "<when test='email!=null'>AND hr_user.email = #{email}</when>",
            "<when test='mobile!=null'>AND hr_user.mobel = #{mobile}</when>",
            "</script>"})
    List<UserItemDto> selectUserPage(@Param("name") String name,@Param("email") String email, @Param("mobile") String mobile, Page<UserItemDto> page);
}
