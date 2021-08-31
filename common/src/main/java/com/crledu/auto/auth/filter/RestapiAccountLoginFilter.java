package com.crledu.auto.auth.filter;

import com.crledu.auto.auth.model.AuthticationToken;
import com.crledu.auto.auth.model.AutoRole;
import com.crledu.auto.auth.model.BaseGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 ************************************************************
 * @Description: 用户跨端登录开放接口登录认证。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/3 9:40
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/

public class RestapiAccountLoginFilter extends AbstractAuthenticationProcessingFilter {



    public static final String DEFAULT_ACCOUNT_NAME = "account";
    public static final String DEFAULT_PASSWORD_NAME ="pass";
    private String usernameParameter = DEFAULT_ACCOUNT_NAME;
    private String passwordParameter =  DEFAULT_PASSWORD_NAME;
    private boolean postOnly = true;

    private RedisTemplate redisTemplate;

    public RestapiAccountLoginFilter(RedisTemplate redisTemplate) {
        super(new AntPathRequestMatcher("/login/rest","POST"));
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !httpServletRequest.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + httpServletRequest.getMethod());
        } else {
            String account = this.obtainAccount(httpServletRequest);
            String password = this.obtainPassword(httpServletRequest);

            if (account == null) {
                account = "";
            }

            if (password == null) {
                password = "";
            }

            account = account.trim();
            List<BaseGrantedAuthority> emptyRoleList = new ArrayList<>();
            emptyRoleList.add(new AutoRole("login"));
            AuthticationToken systemAuthtication = new AuthticationToken(emptyRoleList,account, password);
            this.setDetails(httpServletRequest, systemAuthtication);
            AuthticationToken authentication = (AuthticationToken) this.getAuthenticationManager().authenticate(systemAuthtication);
            redisTemplate.opsForValue().set("login"+authentication.getUserId().toString(),authentication);
            return authentication;
        }
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(this.passwordParameter);
    }

    protected String obtainAccount(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    protected void setDetails(HttpServletRequest request, AuthticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }
}
