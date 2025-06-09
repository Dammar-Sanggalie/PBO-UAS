package com.example.belajar_spring.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String role = (String) session.getAttribute("userRole");
        
        // Jika mencoba akses halaman admin
        if (request.getRequestURI().startsWith("/admin") || 
            request.getRequestURI().startsWith("/dashboard") ||
            request.getRequestURI().startsWith("/konser") ||
            request.getRequestURI().startsWith("/tiket")) {
            
            // Cek apakah user adalah admin
            if (!"ADMIN".equals(role)) {
                response.sendRedirect("/user/home");
                return false;
            }
        }
        return true;
    }
}