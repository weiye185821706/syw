package com.syw.baobao.demo.service;

import com.syw.baobao.demo.dao.BaoAuthMapper;
import com.syw.baobao.demo.entiy.BaoAuth;
import com.syw.baobao.demo.exception.MyException;
import com.syw.baobao.demo.util.RedisUtil;
import com.syw.baobao.demo.util.TokenUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private static Logger logger = LogManager.getLogger("fileLogger");
    @Autowired
    private BaoAuthMapper baoAuthMapper;
    @Autowired
    private RedisUtil redisUtil;
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
            logger.error("账号或者密码错误");
            throw new MyException("账号或者密码错误");
        } else {
            return TokenUtil.sign(baoAuth.getUserid(), baoAuth.getPasswork(), baoAuth.getName(), baoAuth.getUuid());
        }
    }
}
