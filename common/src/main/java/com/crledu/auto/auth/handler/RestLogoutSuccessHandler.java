package com.crledu.auto.auth.handler;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.auth.model.AuthticationToken;
import com.crledu.auto.auth.token.TokenManager;
import com.crledu.auto.web.response.Response;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class RestLogoutSuccessHandler  implements LogoutSuccessHandler {

    /**
     * 用户授权令牌管理组件
     */
    private TokenManager tokenManager;

    private RedisTemplate redisTemplate;

    /**
     *****************************************************************************
     * @Description 退出登录回调函数
     *****************************************************************************
     * @Param [httpServletRequest, httpServletResponse, authentication]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 11:57
     *****************************************************************************
     **/
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json; charset=utf-8");
        AuthticationToken authticationToken = (AuthticationToken) authentication;
        redisTemplate.delete("login"+authticationToken.getUserId().toString());
        tokenManager.deleteToken(authticationToken.getUserId());
        Response response = new Response();
        response.unloginFailure(authentication.getName()+"退出登录成功！");
        String result = JSON.toJSONString(response);
        Writer writer = httpServletResponse.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }

    public RestLogoutSuccessHandler(TokenManager tokenManager,RedisTemplate redisTemplate) {
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }
}
