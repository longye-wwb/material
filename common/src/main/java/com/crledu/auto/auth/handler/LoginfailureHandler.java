package com.crledu.auto.auth.handler;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.web.response.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
/**
 ************************************************************
 * @Description: 用户登录失败处理函数。
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/7/1 9:35
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class LoginfailureHandler implements AuthenticationFailureHandler {

    /**
     *****************************************************************************
     * @Description 登录认证失败的回调函数
     *****************************************************************************
     * @Param [httpServletRequest, httpServletResponse, e]
     * @return void
     *****************************************************************************
     * @Author wenyi
     * @Date 2020/7/1 9:35
     *****************************************************************************
     **/
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        httpServletResponse.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        response.unloginFailure(e.getMessage());
        String result = JSON.toJSONString(response);
        Writer writer = httpServletResponse.getWriter();
        writer.write(result);
        writer.flush();
        writer.close();
    }
}
