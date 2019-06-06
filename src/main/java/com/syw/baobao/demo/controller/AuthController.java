package com.syw.baobao.demo.controller;

import com.syw.baobao.demo.entiy.BaoAuth;
import com.syw.baobao.demo.entiy.Result;
import com.syw.baobao.demo.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(value = "SayController|一个用来测试swagger注解的控制器")
public class AuthController {
    @Autowired
    private AuthService authService;
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value="输入密码", notes="test: 仅1和2有正确返回")
    public Result Login(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "passWord") String passWord) {
        String login = authService.Login(userName, passWord);
        return Result.success(login);
    }

    @ResponseBody
    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    @ApiOperation(value="输入用户名返回用户名")
    public Result<BaoAuth> getUserName(@RequestParam(value = "userName") String userName
                        ) {
        BaoAuth baoAuth = new BaoAuth();
        baoAuth.setName(userName);
        return Result.success(baoAuth);
    }
}
