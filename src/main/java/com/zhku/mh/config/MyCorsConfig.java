//package com.zhku.mh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName:
 * @description 如果在后端配置跨域，集成权限框架会出现跨域问题
 * @author: mh
 * @create: 2019-10-08 09:40
 */
//@Configuration
//public class MyCorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                //security的跨域
//                .exposedHeaders("Access-control-allow-headers",
//                        "Authorization")
//                .allowCredentials(true)
//                .maxAge(1800)
//                .allowedOrigins("http://localhost:8888");
//    }
//}
