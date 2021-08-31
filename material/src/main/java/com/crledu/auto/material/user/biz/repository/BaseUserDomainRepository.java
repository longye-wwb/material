package com.crledu.auto.material.user.biz.repository;

import com.crledu.auto.material.user.biz.domain.UserDomain;
import com.crledu.auto.material.user.biz.dto.LoginUserDetailsDto;
import com.crledu.auto.material.user.biz.dto.UserItemDto;
import com.crledu.auto.material.user.biz.dto.UserSelectDto;
import com.crledu.auto.web.repository.BaseRepository;
import com.crledu.auto.web.response.PageDate;

/**
 ************************************************************
 * @Description: 用户业务对象仓库
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 16:50
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public interface BaseUserDomainRepository extends BaseRepository<UserDomain> {

    PageDate<UserItemDto> selectUserByParam(UserSelectDto selectDto);

    LoginUserDetailsDto findUserByAccount(String account);
}
