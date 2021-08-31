package com.crledu.auto.material.user.biz.service.impl;

import com.crledu.auto.material.user.biz.domain.UserDomain;
import com.crledu.auto.material.user.biz.dto.*;
import com.crledu.auto.material.user.biz.repository.BaseUserDomainRepository;
import com.crledu.auto.material.user.biz.service.BaseUserService;
import com.crledu.auto.web.response.PageDate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 ************************************************************
 * @Description: 用户业务服务实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 10:14
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Service
public class UserServiceImpl implements BaseUserService, UserDetailsService, UserDetailsPasswordService {

    @Resource
    private BaseUserDomainRepository userDomainRepository;

    @Override
    public PageDate<UserItemDto> selectUserPage(UserSelectDto selectDto) {
        return userDomainRepository.selectUserByParam(selectDto);
    }

    @Override
    public UserInfoDto fingUserInfo(Long id) {
        UserDomain userDomain = userDomainRepository.createWithData(id);
        return createUserInfo(userDomain);
    }

    @Override
    public UserInfoDto editeUserProfile(Long id, String profile) {
        UserDomain userDomain = userDomainRepository.createWithData(id);
        userDomain.editeProfile(profile);
        UserDomain newUserDomain = userDomainRepository.updateToData(userDomain);
        return createUserInfo(newUserDomain);
    }

    @Override
    public UserInfoDto createUserWithAccount(UserUpdateDto updateDto, String account, String password) {
        UserDomain userDomain = UserDomain.getInstance(updateDto.getName(),null,updateDto.getBorthday(),updateDto.getEmail(),updateDto.getMobel());
        userDomain.addAccountLogin(account,password);
        UserDomain newUserDoamin = userDomainRepository.saveInData(userDomain);
        return createUserInfo(newUserDoamin);
    }

    @Override
    public UserInfoDto createUserWithCasid(UserUpdateDto updateDto, String account, String password) {
        UserDomain userDomain = UserDomain.getInstance(updateDto.getName(),null,updateDto.getBorthday(),updateDto.getEmail(),updateDto.getMobel());
        userDomain.addCasLogin(account,password);
        UserDomain newUserDoamin = userDomainRepository.saveInData(userDomain);
        return createUserInfo(newUserDoamin);
    }

    private UserInfoDto createUserInfo(UserDomain userDomain){
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setId(userDomain.getId());
        userInfoDto.setBorthday(userDomain.getBorthday());
        userInfoDto.setEmail(userDomain.getEmail());
        userInfoDto.setMobel(userDomain.getMobail());
        userInfoDto.setName(userDomain.getName());
        userInfoDto.setProfile(userDomain.getProfile());
        userInfoDto.setStatus(userDomain.getStatus());
        return userInfoDto;
    }

    @Override
    public UserDetails updatePassword(UserDetails userDetails, String s) {
        if(userDetails instanceof LoginUserDetailsDto){

        }else {
            userDetails = loadUserByUsername(userDetails.getUsername());
        }
        LoginUserDetailsDto userDetailsDto = (LoginUserDetailsDto) userDetails;
        UserDomain userDomain = userDomainRepository.createWithData(userDetailsDto.getId());
        userDomain.changeUserPassword(userDetailsDto.getPassword(),userDetailsDto.getUsername());
        userDomainRepository.updateToData(userDomain);
        return userDetailsDto;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = userDomainRepository.findUserByAccount(s);
        if(userDetails == null){
            throw new UsernameNotFoundException("用户账号不存在。");
        }
        return userDetails;
    }
}
