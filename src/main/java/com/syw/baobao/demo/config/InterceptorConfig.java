package com.syw.baobao.demo.config;

import com.syw.baobao.demo.fiter.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        JwtInterceptor jwtInterceptor = new JwtInterceptor();
        InterceptorRegistration addInterceptor = registry.addInterceptor(jwtInterceptor);
        // 拦截请求
        addInterceptor.addPathPatterns("/**");
        // 排除路径
        addInterceptor.excludePathPatterns("/user/login");
        addInterceptor.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        addInterceptor.excludePathPatterns("/");
        // 排除资源请求
        addInterceptor.excludePathPatterns("/css/login/*.css");
        addInterceptor.excludePathPatterns("/js/login/**/*.js");
        addInterceptor.excludePathPatterns("/image/login/*.png");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }
}
