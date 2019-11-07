package com.zhku.mh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName：
 * Time：2019/11/7 15:35
 * Description：
 * Author： mh
 **
 *
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Bean
    public ExecutorService executorService(){
        return Executors.newCachedThreadPool();
    }

}
