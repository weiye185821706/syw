package com.syw.baobao.demo.fiter;

import com.syw.baobao.demo.util.TokenUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token != null) {
            boolean verify = TokenUtil.verify(token);
            if (verify) {
                System.out.println("验证通过");
                return true;
            }
        }
        System.out.println("认证失败");
        return false;
    }
}
