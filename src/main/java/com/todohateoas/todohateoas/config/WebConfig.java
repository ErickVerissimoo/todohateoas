package com.todohateoas.todohateoas.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class WebConfig {
@Bean
public ModelMapper getMapper(){
return new ModelMapper();
}
}
