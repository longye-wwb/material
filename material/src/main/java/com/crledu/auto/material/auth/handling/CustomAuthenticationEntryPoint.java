package com.crledu.auto.material.auth.handling;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.util.http.RequistUtils;
import com.crledu.auto.web.response.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 ************************************************************
 * @Description: 用户认证异常处理端点
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/10 17:34
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if(RequistUtils.isAjaxRequest(httpServletRequest)){
            httpServletResponse.setContentType("application/json; charset=utf-8");
            Response response = new Response();
            response.unloginFailure(e.getMessage());
            String result = JSON.toJSONString(response);
            Writer writer = httpServletResponse.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        }else{
            httpServletResponse.sendRedirect("../login");
        }
    }
}
