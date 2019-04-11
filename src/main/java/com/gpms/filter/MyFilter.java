package com.gpms.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyFilter implements Filter {

    @Override

    public void destroy() {

        // TODO Auto-generated method stub

    }



    @Override

    public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)

            throws IOException, ServletException {

//        HttpServletResponse response = (HttpServletResponse) sresponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
//        response.setHeader("Access-Control-Allow-Credentials", "true");

        filterChain.doFilter(srequest, sresponse);

    }



    @Override

    public void init(FilterConfig arg0) throws ServletException {

        // TODO Auto-generated method stub

    }

}