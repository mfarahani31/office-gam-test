package ir.gam.office.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LogInterceptor logInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // LogInterceptor apply to all URLs.
        registry.addInterceptor(logInterceptor);


//        registry.addInterceptor(new LogInterceptor())
//                .addPathPatterns("/secure-code")
//                .excludePathPatterns("/secure-code/public"); //by default applies to
//        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/auth");

        // Register admin interceptor with multiple path patterns
        /*registry.addInterceptor(new LogInterceptor())
                .addPathPatterns(new String[] { "/admin", "/admin*//*" });
         */
//        registry.addInterceptor((new SubLogInterceptor())).addPathPatterns("/admin/*").excludePathPatterns("admin/oldLogin");


        // LogInterceptor apply to all URLs.
        //registry.addInterceptor(logInterceptor);

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
