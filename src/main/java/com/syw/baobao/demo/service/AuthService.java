package com.syw.baobao.demo.service;

import com.syw.baobao.demo.util.TokenUtil;
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
        String name = "123456";
        String pwd = "123456";
        if (name.equals(userName) && pwd.equals(passWord)) {
            return TokenUtil.sign(userName, passWord);
        }
        return "密码错误";
    }
}
