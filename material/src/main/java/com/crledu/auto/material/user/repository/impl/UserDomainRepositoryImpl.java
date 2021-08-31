package com.crledu.auto.material.user.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crledu.auto.auth.conf.CredentialType;
import com.crledu.auto.auth.model.BaseGrantedAuthority;
import com.crledu.auto.material.user.biz.domain.CredentialDomain;
import com.crledu.auto.material.user.biz.domain.UserDomain;
import com.crledu.auto.material.user.biz.dto.LoginUserDetailsDto;
import com.crledu.auto.material.user.biz.dto.RoleAuthority;
import com.crledu.auto.material.user.biz.dto.UserItemDto;
import com.crledu.auto.material.user.biz.dto.UserSelectDto;
import com.crledu.auto.material.user.biz.repository.BaseUserDomainRepository;
import com.crledu.auto.material.user.repository.dao.BaseCredentialsMapper;
import com.crledu.auto.material.user.repository.dao.BaseUserMapper;
import com.crledu.auto.material.user.repository.entity.CredentialsEntity;
import com.crledu.auto.material.user.repository.entity.UserEntity;
import com.crledu.auto.util.string.SqlUtils;
import com.crledu.auto.web.exception.RestRuntimeException;
import com.crledu.auto.web.response.PageDate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 用户业务对象仓库的mysql实现
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/9 16:53
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
@Repository
public class UserDomainRepositoryImpl implements BaseUserDomainRepository {

    @Resource
    private BaseCredentialsMapper credentialsMapper;

    @Resource
    private BaseUserMapper userMapper;

    @Override
    public UserDomain createWithData(Long id) {
        UserEntity userEntity = userMapper.selectById(id);
        if(userEntity != null){
            QueryWrapper<CredentialsEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user",id);
            List<CredentialsEntity> credentialsEntityList = credentialsMapper.selectList(queryWrapper);
            List<CredentialDomain> credentialDomainList = new ArrayList<>();
            if(credentialsEntityList != null && credentialsEntityList.size()>0){
                for(CredentialsEntity credentialsEntity:credentialsEntityList){
                    CredentialDomain credentialDomain = new CredentialDomain(credentialsEntity.getId(),credentialsEntity.getUser(),credentialsEntity.getType(),credentialsEntity.getAccount(),credentialsEntity.getPassword(),credentialsEntity.getAccountExpired(),credentialsEntity.getPasswordExpired(),credentialsEntity.getLocked()==1,credentialsEntity.getEnable()==1);
                    credentialDomainList.add(credentialDomain);
                }
            }
            UserDomain userDomain = new UserDomain(userEntity.getId(),userEntity.getName(),userEntity.getProfile(),userEntity.getBorthday(),userEntity.getEmail(),userEntity.getMobel(),userEntity.getCurStatus(),credentialDomainList);
            return userDomain;
        }else{
            throw new RestRuntimeException("业务对象不存在。","1900000001");
        }
    }

    @Override
    public UserDomain saveInData(UserDomain domain) {
        UserEntity userEntity = new UserEntity();
        copyUserEntityfromDomain(domain,userEntity);
        userMapper.insert(userEntity);
        if(domain.getCredentialDomains() != null && domain.getCredentialDomains().size() > 0){
            for(CredentialDomain credentialDomain:domain.getCredentialDomains()){
                CredentialsEntity credentialsEntity = new CredentialsEntity();
                copyCredencialFromDomain(credentialDomain,credentialsEntity);
                credentialsEntity.setUser(userEntity.getId());
                credentialsMapper.insert(credentialsEntity);
            }

        }
        return createWithData(userEntity.getId());
    }

    @Override
    public UserDomain updateToData(UserDomain domain) {
        UserEntity userEntity = userMapper.selectById(domain.getId());
        if(userEntity == null){
            throw new RestRuntimeException("用户不存在","1000000001");
        }else{
            copyUserEntityfromDomain(domain,userEntity);
            userMapper.updateById(userEntity);
            for(CredentialDomain credentialDomain : domain.getCredentialDomains()){
                if(credentialDomain.getId() == null){
                    CredentialsEntity credentialsEntity = new CredentialsEntity();
                    copyCredencialFromDomain(credentialDomain,credentialsEntity);
                    credentialsEntity.setUser(userEntity.getId());
                    credentialsMapper.insert(credentialsEntity);
                }else{
                    CredentialsEntity credentialsEntity = credentialsMapper.selectById(credentialDomain.getId());
                    copyCredencialFromDomain(credentialDomain,credentialsEntity);
                    credentialsEntity.setUser(userEntity.getId());
                    credentialsMapper.updateById(credentialsEntity);
                }
            }
        }
        return createWithData(domain.getId());
    }

    @Override
    public Boolean deleteFromData(Long id) {
        QueryWrapper<CredentialsEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user",id);
        credentialsMapper.delete(queryWrapper);
        userMapper.deleteById(id);
        return true;
    }

    private void copyUserEntityfromDomain(UserDomain userDomain,UserEntity userEntity){
        userEntity.setBorthday(userDomain.getBorthday());
        userEntity.setCurStatus(userDomain.getStatus());
        userEntity.setEmail(userDomain.getEmail());
        userEntity.setMobel(userDomain.getMobail());
        userEntity.setName(userDomain.getName());
        userEntity.setProfile(userDomain.getProfile());
    }

    private void copyCredencialFromDomain(CredentialDomain credentialDomain,CredentialsEntity credentialsEntity){
        credentialsEntity.setAccount(credentialDomain.getAccount());
        credentialsEntity.setAccountExpired(credentialDomain.getAccountExpired());
        if(credentialDomain.getEnable()){
            credentialsEntity.setEnable(1);
        }else{
            credentialsEntity.setEnable(0);
        }
        if(credentialDomain.getLocked()){
            credentialsEntity.setLocked(1);
        }else{
            credentialsEntity.setLocked(0);
        }
        credentialsEntity.setPassword(credentialDomain.getPassword());
        credentialsEntity.setPasswordExpired(credentialDomain.getPasswordExpired());
        credentialsEntity.setType(credentialDomain.getType());
        credentialsEntity.setUser(credentialDomain.getUser());
    }

    @Override
    public PageDate<UserItemDto> selectUserByParam(UserSelectDto selectDto) {
        Page<UserItemDto> page = new Page<>(selectDto.getPageNum(),selectDto.getPageSize());
        List<UserItemDto> list = userMapper.selectUserPage(SqlUtils.allLikeString(selectDto.getName()),selectDto.getEmail(),selectDto.getMobel(),page);
        page.setRecords(list);
        return new PageDate<>(page);
    }

    @Override
    public LoginUserDetailsDto findUserByAccount(String account) {
        QueryWrapper<CredentialsEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", CredentialType.ACCOUNT.getCode());
        queryWrapper.eq("account",account);
        List<CredentialsEntity> credentialsEntityList = credentialsMapper.selectList(queryWrapper);
        if(credentialsEntityList != null && credentialsEntityList.size() == 1){
            UserEntity userEntity = userMapper.selectById(credentialsEntityList.get(0).getUser());
            //组装用户的权限
            RoleAuthority loginRole = new RoleAuthority("login");
            List<RoleAuthority> authorities = new ArrayList<>();
            authorities.add(loginRole);
            //组装基础用户数据
            LoginUserDetailsDto loginUserDetailsDto = new LoginUserDetailsDto(credentialsEntityList.get(0).getAccount(),credentialsEntityList.get(0).getPassword(),authorities);
            loginUserDetailsDto.setId(userEntity.getId());
            loginUserDetailsDto.setBorthday(userEntity.getBorthday());
            loginUserDetailsDto.setEmail(userEntity.getEmail());
            loginUserDetailsDto.setMobel(userEntity.getMobel());
            loginUserDetailsDto.setProfile(userEntity.getProfile());
            return loginUserDetailsDto;
        }
        return null;
    }
}
