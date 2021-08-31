package com.crledu.auto.auth.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 ************************************************************
 * @Description: 认证查询出来的用户信息。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:31
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class LoginUser implements UserDetails {

    /**
     * 登录用户的主键
     */
    private Long userId;

    /**
     * 登录用户的头像
     */
    private String profile;

    /**
     * 登录用户的名称
     */
    private String name;

    /**
     * 用户的登录凭证
     */
    private AbstractCredential credential;

    /**
     * 登录用户的角色数组
     */
    private List<AutoRole> roleList;

    /**
     * 登录用户的权限数组
     */
    private List<AutoPermission> permissionList;


    private String email;

    private String addr;

    private String orgName;

    private Long org;



    public LoginUser() {
    }

    public LoginUser(String profile, String name, AbstractCredential credential, List<AutoRole> roleList, List<AutoPermission> permissionList,String email,String addr,String orgName,Long org) {
        this.userId = credential.getUser();
        this.profile = profile;
        this.name = name;
        this.credential = credential;
        this.roleList = roleList;
        this.permissionList = permissionList;
        this.email=email;
        this.addr=addr;
        this.orgName=orgName;
        this.org=org;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<BaseGrantedAuthority> authorities = new ArrayList<>();
        authorities.addAll(this.roleList);
        authorities.addAll(this.permissionList);
        return authorities;
    }

    @Override
    public String getPassword() {
        return credential.getPassword();
    }

    @Override
    public String getUsername() {
        return credential.getAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return credential.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return credential.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credential.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return credential.getEnable();
    }

    public Long getUserId() {
        return credential.getId();
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoleList(List<AutoRole> roleList) {
        this.roleList = roleList;
    }

    public void setPermissionList(List<AutoPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getProfile() {
        return profile;
    }

    public  Long getUser(){
        return this.userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrg() {
        return org;
    }

    public void setOrg(Long org) {
        this.org = org;
    }

    public String getName(){
        return this.name;
    }


}
