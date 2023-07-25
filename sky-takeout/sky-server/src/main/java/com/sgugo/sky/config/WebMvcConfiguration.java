package com.sgugo.sky.config;

import com.sgugo.sky.interceptors.TokenAdminInterceptor;
import com.sgugo.sky.interceptors.TokenUserInterceptors;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Log4j2
public class WebMvcConfiguration  extends WebMvcConfigurationSupport {
    @Autowired
    private TokenAdminInterceptor tokenAdminInterceptor;

    @Autowired
    private TokenUserInterceptors tokenUserInterceptors;

    protected void addInterceptors(InterceptorRegistry registry){
        log.info("开始注册自定义拦截器");

        //1. 注册admin Token拦截器
        registry.addInterceptor(tokenAdminInterceptor)
                //1.1 配置生效范围：/admin/ 下的所有API都生效
                .addPathPatterns("/admin/**")
                //1.2 配置排除范围：登录接口是不需要鉴权的
                .excludePathPatterns("/admin/employee/login");

        //2. 注册user Token拦截器
        registry.addInterceptor(tokenUserInterceptors)
                //2.1 配置生效范围：/user/ 下的所有API都生效
                .addPathPatterns("/user/**")
                //2.2 配置排除范围：登录接口是不需要鉴权的
                .excludePathPatterns("/user/user/login")
                .excludePathPatterns("/user/shop/status");
    }

    @Override
    //自定义一个资源（目录）拦截器，对api文档进行放行
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //配置knife4j 显示文档
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        //顺便配置swagger-ui显示文档
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        //API文档用到的 公共资源部分
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
