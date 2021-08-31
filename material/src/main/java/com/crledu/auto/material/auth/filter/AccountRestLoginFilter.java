package com.crledu.auto.material.auth.filter;

import com.alibaba.fastjson.JSONObject;
import com.crledu.auto.material.auth.handling.CustomSavedRequestAwareAuthenticationSuccessHandler;
import com.crledu.auto.web.exception.RestRuntimeException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AccountRestLoginFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    private String usernameParameter = "username";
    private String passwordParameter = "password";
    private boolean postOnly = true;

    public AccountRestLoginFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        this.setAuthenticationSuccessHandler(new CustomSavedRequestAwareAuthenticationSuccessHandler());
    }

    protected AccountRestLoginFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
        this.setAuthenticationSuccessHandler(new CustomSavedRequestAwareAuthenticationSuccessHandler());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !httpServletRequest.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + httpServletRequest.getMethod());
        } else {
            String username = this.obtainAccount(httpServletRequest);
            String password = this.obtainPassword(httpServletRequest);
            if (username == null) {
                JSONObject jsonObject = this.obtainAccountInfo(httpServletRequest);
                username = jsonObject.getString(SPRING_SECURITY_FORM_USERNAME_KEY);
                password = jsonObject.getString(SPRING_SECURITY_FORM_PASSWORD_KEY);
                if(username == null){
                    username = "";
                }
            }

            if (password == null) {
                password = "";
            }

            username = username.trim();
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(httpServletRequest, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(this.passwordParameter);
    }

    protected String obtainAccount(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    private JSONObject obtainAccountInfo(HttpServletRequest request){
        try{
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            String inputStr;
            StringBuilder responseStrBuilder = new StringBuilder();
            while ((inputStr = streamReader.readLine()) != null){
                responseStrBuilder.append(inputStr);
            }
            return JSONObject.parseObject(responseStrBuilder.toString());
        }catch (IOException e){
            throw new RestRuntimeException("没有找到用户登录口令","1000000001");

        }
    }
}
