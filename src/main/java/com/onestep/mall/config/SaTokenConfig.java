//package com.onestep.mall.config;
//
//import cn.dev33.satoken.interceptor.SaRouteInterceptor;
//import cn.dev33.satoken.router.SaRouterUtil;
//import cn.dev33.satoken.stp.StpUtil;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class SaTokenConfig implements WebMvcConfigurer {
//    // 注册sa-token的登录拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册登录拦截器，并排除登录接口地址
//        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {
//            SaRouterUtil.match("/**", "/api/v1/login", StpUtil::checkLogin);
//        })).addPathPatterns("/**");
//
//    }
//}
