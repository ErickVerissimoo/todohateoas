package com.todohateoas.todohateoas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todohateoas.todohateoas.dto.UserDto;
import com.todohateoas.todohateoas.dto.TaskDto;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TodohateoasApplicationTests {

	@Inject
	private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();
	
	@BeforeAll
      void contextLoads() throws Exception {
        UserDto dto = new UserDto();
        dto.setEmail("erickverissimodasilva144@gmail.com");
        dto.setPassword("erick12345");

        String dtoJson = mapper.writeValueAsString(dto);

        mvc.perform(post("/public/cadastro")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(dtoJson))
                .andExpect(status().isOk());
        System.out.println("Teste de cadastro realizado com sucesso.");
		assert mvc!=null;
    }

    @Test
	@WithMockUser(username = "erickverissimodasilva144@gmail.com", password = "erick12345", roles = "USER")
    public void addTask() throws Exception {
        TaskDto taskDto = new TaskDto();
        taskDto.setTitle("Lavar a louça");
        taskDto.setDescription("Hora de lavar a louça");

        String dtoJson = mapper.writeValueAsString(taskDto);

        mvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(dtoJson))
                .andExpect(status().isOk()); 

        System.out.println("Teste de adição de tarefa realizado com sucesso.");
    }
}
