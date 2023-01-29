package com.callbus.jaritalkcommunity.config;

import com.callbus.jaritalkcommunity.interceptor.CheckWriteAuthorityInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final CheckWriteAuthorityInterceptor checkWriteAuthorityInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkWriteAuthorityInterceptor)
            .addPathPatterns("/post/**/");
    }
}
