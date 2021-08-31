package com.crledu.auto.auth.filter;

import com.crledu.auto.auth.model.AuthticationToken;
import com.crledu.auto.auth.safe.SignHeader;
import com.crledu.auto.auth.token.TokenInfo;
import com.crledu.auto.auth.token.TokenManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ************************************************************
 * @Description: 用户的token认证信息还原
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/3 9:42
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class RestapiTokenValideteFilter extends OncePerRequestFilter {

    private TokenManager tokenManager;

    private RedisTemplate redisTemplate;

    public RestapiTokenValideteFilter(TokenManager tokenManager,RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try{
            SignHeader signHeader = new SignHeader(httpServletRequest);
            String token = signHeader.getToken();
            if(token != null && !token.trim().isEmpty()){
                TokenInfo  tokenInfo = tokenManager.getToken(token);
                if(tokenInfo == null || tokenInfo.getToken() == null){
                    //用户的token没有通过认证
                    filterChain.doFilter(httpServletRequest,httpServletResponse);
                    return;
                }
                if(tokenManager.checkToken(tokenInfo)){
                    //修复用户的令牌信息。
                    AuthticationToken auth = (AuthticationToken) redisTemplate.opsForValue().get("login"+tokenInfo.getUserId().toString());
                    if(auth == null || !auth.isAuthenticated()){
                        //表明用户已经退出登录，令牌已经失效
                        tokenManager.deleteToken(tokenInfo.getUserId());
                    }
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    filterChain.doFilter(httpServletRequest,httpServletResponse);
                    return ;
                }
            }
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }catch (Exception e){
            throw new ServletException(e.getMessage(),e.getCause());
        }
    }
}
