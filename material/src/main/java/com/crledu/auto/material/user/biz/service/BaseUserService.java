package com.crledu.auto.material.user.biz.service;

import com.crledu.auto.material.user.biz.dto.UserInfoDto;
import com.crledu.auto.material.user.biz.dto.UserItemDto;
import com.crledu.auto.material.user.biz.dto.UserSelectDto;
import com.crledu.auto.material.user.biz.dto.UserUpdateDto;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 用户信息相关功能
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 10:00
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseUserService {

    PageDate<UserItemDto> selectUserPage(UserSelectDto selectDto);
    UserInfoDto fingUserInfo(Long id);
    UserInfoDto editeUserProfile(Long id,String profile);
    UserInfoDto createUserWithAccount(UserUpdateDto updateDto,String account,String password);
    UserInfoDto createUserWithCasid(UserUpdateDto updateDto,String account,String password);
}
