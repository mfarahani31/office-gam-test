package ir.gam.office.config;

import ir.gam.office.interceptor.LogInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;

    //
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // LogInterceptor apply to all URLs.
        registry.addInterceptor(logInterceptor);

        // Old Login url, no longer use.
        // Use OldURLInterceptor to redirect to a new URL.
//        registry.addInterceptor(new OldLoginInterceptor())//
//                .addPathPatterns("/admin/oldLogin");

        // This interceptor apply to URL like /admin/*
        // Exclude /admin/oldLogin
//        registry.addInterceptor(new AdminInterceptor())//
//                .addPathPatterns("/admin/*")//
//                .excludePathPatterns("/admin/oldLogin");
    }
}
