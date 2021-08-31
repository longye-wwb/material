package com.crledu.auto.material.system.api.controller;

import com.crledu.auto.auth.model.AuthticationToken;
import com.crledu.auto.auth.model.LoginUser;
import com.crledu.auto.material.user.biz.dto.LoginUserDetailsDto;
import com.crledu.auto.system.dto.ViewUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.cas.authentication.CasAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 ************************************************************
 * @Description: 统一用户信息获取
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 14:07
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AbstractController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    protected ViewUserDto loginUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof AuthticationToken){
            AuthticationToken authticationToken = (AuthticationToken) authentication;
            return new ViewUserDto(authticationToken.getUserId(),authticationToken.getName(),authticationToken.getProfile());
        } else if(authentication instanceof CasAuthenticationToken) {
            CasAuthenticationToken authenticationToken = (CasAuthenticationToken) authentication;
            LoginUser user = (LoginUser) authenticationToken.getUserDetails();
            return new ViewUserDto(user.getUser(),user.getName(),user.getProfile());
        } else if(authentication instanceof UsernamePasswordAuthenticationToken) {
            LoginUserDetailsDto loginUserDetailsDto = (LoginUserDetailsDto) authentication.getPrincipal();
            return new ViewUserDto(loginUserDetailsDto.getId(),loginUserDetailsDto.getUsername(),loginUserDetailsDto.getProfile());
        }else{
                return  null;

        }
    }
}
