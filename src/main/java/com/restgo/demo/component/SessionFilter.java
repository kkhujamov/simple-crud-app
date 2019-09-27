package com.restgo.demo.component;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class SessionFilter extends GenericFilterBean {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Session session = new Session();
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURL().toString();
        session = session.get(request);
        if (session == null && !url.contains("/login") && !url.contains("/assets/")){
            servletResponse.getOutputStream().println("<script>\n" +
                    "    document.location = '/login'\n" +
                    "</script>");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
