package com.todohateoas.todohateoas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class testsBeans {
@Bean
public ObjectMapper mapper(){
    return new ObjectMapper();
}
}
