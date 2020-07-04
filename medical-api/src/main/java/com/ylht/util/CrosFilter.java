package com.ylht.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        //*号表示对所有请求都允许跨域访问
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.addHeader("Access-Control-Allow-Methods","*");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type, Content-Length, Authorization, Accept, X-Requested-With , yourHeaderFeild,token");
        res.setHeader("Access-Control-Expose-Headers", "*");
        res.addHeader("X-Powered-By"," 3.2.1");
        res.addHeader("Content-Type", "application/json;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }


    public void destroy() {

    }
}
