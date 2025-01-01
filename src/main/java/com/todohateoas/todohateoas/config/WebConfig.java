package com.todohateoas.todohateoas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.filter.RequestContextFilter;


@Configuration
@EnableAspectJAutoProxy
public class WebConfig {
@Bean
public ModelMapper getMapper(){
return new ModelMapper();
}

@Bean
public ThreadPoolTaskExecutor executor(){
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.initialize();
    return executor;
}
@Bean
public RequestContextFilter filter(){
    return new RequestContextFilter();
}
}
