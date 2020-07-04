package com.ylht.interceptor;

import com.ylht.enums.ApiResponseEnum;
import com.ylht.util.ApiResponse;
import com.ylht.util.ApiResponseUtil;
import com.ylht.util.JwtUtil;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInterceptor implements HandlerInterceptor {
    public TokenInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        System.out.println(token);
        if (null != token) {
            boolean result = JwtUtil.verify(token);
            if (result) {
                return true;
            }
        }

        ApiResponse apiResponse = ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);
        this.responseMessage(response, response.getWriter(), apiResponse);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private void responseMessage(HttpServletResponse response, PrintWriter out, ApiResponse apiResponse) {
    }
}
