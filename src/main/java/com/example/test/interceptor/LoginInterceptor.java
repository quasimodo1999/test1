package com.example.test.interceptor;



import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user != null)
            return true;
        else {
            handleFalseResponse(response);
            return false;
        }

    }

    /**
     * 用户若未登录应该返回的数据
     * @param response
     * @throws Exception
     */
    private void handleFalseResponse(HttpServletResponse response)
            throws Exception {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"code\": \"200\", \"msg\": \"尚未登录\", \"isSuccess\": \"false\"}");
        response.getWriter().flush();
    }

}
