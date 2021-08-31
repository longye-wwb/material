package com.crledu.auto.auth.handler;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.auth.model.AuthticationToken;
import com.crledu.auto.auth.token.TokenInfo;
import com.crledu.auto.auth.token.TokenManager;
import com.crledu.auto.web.response.Response;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 ************************************************************
 * @Description: 用户登录成功的回调函数。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/1 9:30
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 用户授权令牌管理组件
     */
    private TokenManager tokenManager;

    public LoginSuccessHandler(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    /**
     *****************************************************************************
     * @Description 登录成功回调函数
     *****************************************************************************
     * @Param [httpServletRequest, httpServletResponse, authentication]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 9:31
     *****************************************************************************
     **/
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        AuthticationToken authticationToken = (AuthticationToken) authentication;
        //签发令牌
        TokenInfo tokenInfo = tokenManager.createToken(authticationToken.getUserId());
        //缓存用户当前的令牌。
        httpServletResponse.setContentType("application/json; charset=utf-8");
        Response response = new Response().success(tokenInfo);
        String result = JSON.toJSONString(response);
        Writer writer = httpServletResponse.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
