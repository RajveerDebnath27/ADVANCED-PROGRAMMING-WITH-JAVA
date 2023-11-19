package com.example.lab_task_2;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebFilter("/welcome.jsp")
public class AuthenticationFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        if (session != null && session.getAttribute("fullName") != null) {
            // User is logged in, proceed to the requested resource
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to login page
            ((HttpServletResponse) response).sendRedirect("login.jsp");
        }
    }

    public void destroy() {
        // Cleanup code if needed
    }
}

