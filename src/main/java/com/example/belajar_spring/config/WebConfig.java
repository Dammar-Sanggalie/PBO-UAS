package com.example.belajar_spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    
    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Login interceptor
        registry.addInterceptor(loginInterceptor)
               .addPathPatterns("/**")
               .excludePathPatterns(
                    "/auth/login",
                    "/auth/register",
                    "/css/**",
                    "/js/**",
                    "/images/**"
               );
               
        // Admin interceptor hanya untuk path admin
        registry.addInterceptor(adminInterceptor)
               .addPathPatterns("/admin/**", "/dashboard/**", "/konser/**", "/tiket/**")
               .excludePathPatterns("/user/**"); // Exclude path user
    }
}
