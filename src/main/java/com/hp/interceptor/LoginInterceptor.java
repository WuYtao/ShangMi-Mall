package com.hp.interceptor;

import com.hp.pojo.Admins;
import com.hp.pojo.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String url = request.getRequestURI().toString();
        if (url.contains("login")) {
            return true;
        }
        System.out.println("url = " + url);
        String[] split = url.split("/");
        if (split[1].equals("index")) {
            Users login = (Users) session.getAttribute("login");
            if (login != null) {
                return true;
            } else {
                request.getRequestDispatcher("/index/login").forward(request, response);
                return false;
            }
        } else if (split[1].equals("admin")) {
            Admins alog = (Admins) session.getAttribute("alog");
            if (alog != null) {
                return true;
            } else {
                request.getRequestDispatcher("/admin/login").forward(request, response);
                return false;
            }
        }
        return false;
    }
}
