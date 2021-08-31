package com.crledu.auto.material.user.api.controller;

import com.crledu.auto.material.system.api.controller.AbstractController;
import com.crledu.auto.material.user.api.vo.UserCreaterVo;
import com.crledu.auto.material.user.api.vo.UserItemVo;
import com.crledu.auto.material.user.api.vo.UserSelectVo;
import com.crledu.auto.material.user.biz.dto.UserInfoDto;
import com.crledu.auto.material.user.biz.dto.UserItemDto;
import com.crledu.auto.material.user.biz.dto.UserSelectDto;
import com.crledu.auto.material.user.biz.dto.UserUpdateDto;
import com.crledu.auto.material.user.biz.service.BaseUserService;
import com.crledu.auto.system.dto.ViewUserDto;
import com.crledu.auto.web.response.PageDate;
import com.crledu.auto.web.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("user")
@Api(tags = "user-用户管理接口")
public class UserController extends AbstractController {

    @Resource
    private BaseUserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/new")
    private Response<UserItemVo> createUserByAccount(@RequestBody @Valid UserCreaterVo createrVo){
        UserUpdateDto updateDto = new UserUpdateDto();
        updateDto.setBorthday(createrVo.getBorthday());
        updateDto.setEmail(createrVo.getEmail());
        updateDto.setMobel(createrVo.getMobel());
        updateDto.setName(createrVo.getName());
        UserInfoDto userInfoDto = userService.createUserWithAccount(updateDto,createrVo.getAccount(),createrVo.getPasseord());
        return new Response().success(new UserItemVo(userInfoDto));
    }

    @ApiOperation("分页查询用户列表")
    @GetMapping("/page")
    private Response<PageDate<UserItemDto>> findUserByParam(UserSelectVo selectVo){
        UserSelectDto userSelectDto = new UserSelectDto();
        userSelectDto.setPageNum(selectVo.getPageNum());
        userSelectDto.setPageSize(selectVo.getPageSize());
        userSelectDto.setEmail(selectVo.getEmail());
        userSelectDto.setMobel(selectVo.getMobel());
        userSelectDto.setName(selectVo.getName());
        return new Response<>().success(userService.selectUserPage(userSelectDto));
    }

    @ApiOperation("获取当前登录用户")
    @GetMapping("/current")
    public Response<ViewUserDto> getCurrentUser(){
        return new Response().success(loginUser());
    }

    @ApiOperation("用户详情")
    @GetMapping("/info")
    private Response<UserInfoDto> findUserInfo(Long id){
        return new Response<>().success(userService.fingUserInfo(id));
    }

    @ApiOperation("修改用户头像")
    @PostMapping("/profile")
    private Response<UserInfoDto> editeUserProfile(Long id,String profile){
        return new Response<>().success(userService.editeUserProfile(id,profile));
    }
}
