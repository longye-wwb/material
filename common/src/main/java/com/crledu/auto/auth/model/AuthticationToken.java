package com.crledu.auto.auth.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 ************************************************************
 * @Description: 系统用户通过账号密码登录的认证信息
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/2 17:27
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class AuthticationToken extends AbstractAuthenticationToken implements Serializable {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;




    private LoginUser loginUser;

    public AuthticationToken(Collection<? extends GrantedAuthority> authorities, String account, String password) {
        super(authorities);
        this.account = account;
        this.password = password;
    }
    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getPrincipal(){
        return account;
    }

    public void authenticated(LoginUser loginUser){
        this.loginUser = loginUser;
        this.setAuthenticated(true);
    }

    public Long getUserId(){
        LoginUser loginUser = this.loginUser;
        return loginUser.getUserId();
    }


    public LoginUser getLoginUser() {
        return loginUser;
    }

    public String getProfile(){
        return this.loginUser.getProfile();
    }
}
