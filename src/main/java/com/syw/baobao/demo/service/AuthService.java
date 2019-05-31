package com.syw.baobao.demo.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    /**
     * 登录接口
     * @param userName
     * @param passWord
     * @return
     */
    public String Login(String userName, String passWord) {
        return "登录成功";
    }
}
