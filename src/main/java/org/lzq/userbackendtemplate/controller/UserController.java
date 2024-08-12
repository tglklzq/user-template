package org.lzq.userbackendtemplate.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;

import org.lzq.userbackendtemplate.common.BaseResponse;
import org.lzq.userbackendtemplate.common.ErrorCode;
import org.lzq.userbackendtemplate.common.ResultUtils;
import org.lzq.userbackendtemplate.exception.BusinessException;
import org.lzq.userbackendtemplate.model.request.UserLoginRequest;
import org.lzq.userbackendtemplate.model.request.UserRegisterRequest;
import org.lzq.userbackendtemplate.model.request.UserUpdateRequest;
import org.lzq.userbackendtemplate.model.response.UserLoginResponse;
import org.lzq.userbackendtemplate.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;


    @PostMapping("/register")
    public BaseResponse<String> userRegister(@RequestBody @Valid UserRegisterRequest requestParam) {
        if (requestParam == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        userService.userRegister(requestParam);
        return ResultUtils.success("注册成功");
        //return ResultUtils.success(null,"注册成功");
    }

    @PostMapping("/login")
    public BaseResponse<UserLoginResponse> userLogin(@RequestBody @Valid UserLoginRequest requestParam) {
        if (requestParam == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(userService.userLogin(requestParam));
    }
    @PostMapping("/update")
    public BaseResponse<String> updateUser(@RequestBody @Valid UserUpdateRequest requestParam) {
        if (requestParam == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        userService.updateUser(requestParam);
        return ResultUtils.success("更新成功");
    }
    @GetMapping("check-login")
    public BaseResponse<String> checkLogin(@RequestParam ("username") String userName,@RequestParam("token") String token){
        boolean result =userService.checkLogin(userName,token);
        if (result)
            return ResultUtils.success("用户已登录");
        else
            return ResultUtils.error(ErrorCode.NOT_LOGIN,"用户未登录");

    }
    @DeleteMapping("/logout")
    public BaseResponse<String> logOut(@RequestParam ("username") String userName,@RequestParam("token") String token){
        userService.logout(userName,token);
        return ResultUtils.success("用户已退出");
    }



}
