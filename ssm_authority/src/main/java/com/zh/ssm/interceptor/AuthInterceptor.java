package com.zh.ssm.interceptor;

import com.zh.ssm.pojo.Auth;
import com.zh.ssm.pojo.UserVo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //bookController/findBook  -->path
        //bookController#findBook  -->handler
        String str = handler.toString();
        HttpSession session = request.getSession();
        UserVo userVo = (UserVo) session.getAttribute("myuser");
        List<Auth> authList = userVo.getAuthList();
        for (Auth auth : authList) {
            String path = auth.getPath();
            String[] split = path.split("/");
            String a = split[0].substring(0, 1);
            String b = split[0].substring(1);
            String c = a.toUpperCase() + b;
            if (str.contains(c) && str.contains(split[1])){
                return true;
            }
        }
        request.setAttribute("msg",userVo.getUsername()+"您的权限不够，请联系管理员");
        request.getRequestDispatcher("/book/error.jsp").forward(request,response);
        return false;
    }
}
