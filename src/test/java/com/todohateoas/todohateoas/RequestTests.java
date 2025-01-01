package com.todohateoas.todohateoas;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todohateoas.todohateoas.dto.UserDto;
import com.todohateoas.todohateoas.hateoas.model.UserModel;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class RequestTests {
    @Autowired
    private TestRestTemplate template;
    

@Test
void teste() throws JsonProcessingException{

    UserDto dto = new UserDto();
dto.setEmail("erickverissimodasilva144@gmail.com");
dto.setPassword("erick1234");
ObjectMapper mapper = new ObjectMapper();
String jsonDto = mapper.writeValueAsString(dto);
System.out.println(jsonDto);
    var e = template.postForEntity(URI.create("http://localhost:8080/public/cadastro"), dto, UserModel.class);
    Assert.notNull(e.getBody().getEmail());
}
}
