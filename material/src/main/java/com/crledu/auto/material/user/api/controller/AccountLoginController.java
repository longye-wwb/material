package com.crledu.auto.material.user.api.controller;

import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户账号相关接口")
@RestController
@RequestMapping("account")
public class AccountLoginController {

    @ApiOperation("账号密码登录")
    @PostMapping("/login")
    public Response accountLogin(String username,String password){
        return new Response().success();
    }
}
