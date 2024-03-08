package com.threewater.utils;


import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/10/19:30
 * @Description:
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 校验登录信息
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 判断是否需要拦截 ThreadLocal中是否有用户
        if (UserHolder.getUser() == null) {
            // 没有，需要拦截，设置状态码
            response.setStatus(401);
            return false;
        }
        // 有用户，则放行
        return true;
    }

}
