package com.crledu.auto.material.auth.handling;

import com.alibaba.fastjson.JSON;
import com.crledu.auto.util.http.RequistUtils;
import com.crledu.auto.web.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 ************************************************************
 * @Description: 登陆成功的页面跳转
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2020/11/19 18:03
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class CustomSavedRequestAwareAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    protected final Log logger = LogFactory.getLog(this.getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();

    public CustomSavedRequestAwareAuthenticationSuccessHandler() {
        this.setDefaultTargetUrl("http://localhost:8080/login/account");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication authentication) throws ServletException, IOException {
        SavedRequest savedRequest = this.requestCache.getRequest(request, httpServletResponse);
        if(RequistUtils.isAjaxRequest(request)){
            this.clearAuthenticationAttributes(request);
            Authentication authentication12 = SecurityContextHolder.getContext().getAuthentication();
            httpServletResponse.setContentType("application/json; charset=utf-8");
            Response response = new Response();
            response.success();
            String result = JSON.toJSONString(response);
            Writer writer = httpServletResponse.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        }else {
            if (savedRequest == null) {
                super.onAuthenticationSuccess(request, httpServletResponse, authentication);
            } else {
                String targetUrlParameter = this.getTargetUrlParameter();
                if (!this.isAlwaysUseDefaultTargetUrl() && (targetUrlParameter == null || !StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
                    this.clearAuthenticationAttributes(request);
                    String targetUrl = savedRequest.getRedirectUrl();
                    this.logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
                    this.getRedirectStrategy().sendRedirect(request, httpServletResponse, "/account/login");
                } else {
                    this.requestCache.removeRequest(request, httpServletResponse);
                    super.onAuthenticationSuccess(request, httpServletResponse, authentication);
                }
            }
        }
    }

    public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
    }
}
