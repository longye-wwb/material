package com.crledu.auto.material.auth;

import com.crledu.auto.material.auth.filter.AccountRestLoginFilter;
import com.crledu.auto.material.auth.handling.CustomAuthenticationEntryPoint;
import com.crledu.auto.material.auth.provider.CustomUsernamePasswordAutheticationProvider;
import com.crledu.auto.material.user.biz.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class RestapiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Bean
    public AccountRestLoginFilter accountRestLoginFilter() throws Exception {
        AccountRestLoginFilter accountRestLoginFilter = new AccountRestLoginFilter("/account/login");
        accountRestLoginFilter.setAuthenticationManager(this.authenticationManagerBean());
        return accountRestLoginFilter;
    }

    @Bean
    public CustomUsernamePasswordAutheticationProvider customUsernamePasswordAutheticationProvider(){
        CustomUsernamePasswordAutheticationProvider customUsernamePasswordAutheticationProvider = new CustomUsernamePasswordAutheticationProvider();
        customUsernamePasswordAutheticationProvider.setUserDetailsService(userService);
        customUsernamePasswordAutheticationProvider.setUserDetailsPasswordService(userService);
        customUsernamePasswordAutheticationProvider.setPasswordEncoder(passwordEncoder);
        return customUsernamePasswordAutheticationProvider;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(this.customUsernamePasswordAutheticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // swagger
                .antMatchers("/**/*.html").permitAll()
                .antMatchers("/swagger**/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/public/**").permitAll()
                .antMatchers(HttpMethod.GET).permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated().and().formLogin().permitAll().successForwardUrl("/login/account").and().addFilterBefore(accountRestLoginFilter(), UsernamePasswordAuthenticationFilter.class).exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
        http.csrf().disable();
        //跨域
        http.cors();
    }
}
