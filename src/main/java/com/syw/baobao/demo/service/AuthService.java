package com.syw.baobao.demo.service;

import com.syw.baobao.demo.dao.BaoAuthMapper;
import com.syw.baobao.demo.entiy.BaoAuth;
import com.syw.baobao.demo.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private BaoAuthMapper baoAuthMapper;

    /**
     * 登录接口
     *
     * @param userName
     * @param passWord
     * @return
     */
    public String Login(String userName, String passWord) {
        BaoAuth baoAuth = new BaoAuth();
        baoAuth.setPasswork(passWord);
        baoAuth.setUserid(userName);
        baoAuth = baoAuthMapper.selectByPrimaryKey(baoAuth);
        if (baoAuth == null) {
            return "账号或者密码错误";
        } else {
            return TokenUtil.sign(baoAuth.getUserid(), baoAuth.getPasswork(), baoAuth.getName(), baoAuth.getUuid());
        }
    }
}
