package com.ylht.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetUserUtil {
    public GetUserUtil() {
    }

    public static Integer getUserId(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        String userId = JwtUtil.getUserId(token);
        return Integer.parseInt(userId);
    }
}
