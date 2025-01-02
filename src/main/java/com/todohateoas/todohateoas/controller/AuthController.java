package com.todohateoas.todohateoas.controller;

import java.time.Duration;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import com.todohateoas.todohateoas.dto.UserDto;
import com.todohateoas.todohateoas.hateoas.assembler.UserModelAssembler;
import com.todohateoas.todohateoas.hateoas.model.UserModel;
import com.todohateoas.todohateoas.model.User;
import com.todohateoas.todohateoas.service.UserService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/public")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final ModelMapper mapper;
    private final UserService service;
    private final UserModelAssembler assembler;
    private final ThreadPoolTaskExecutor executor;
@PostMapping("/cadastro")
public DeferredResult<UserModel> signup(@RequestBody UserDto entity) throws NoSuchMethodException, SecurityException {
 DeferredResult<UserModel> model = new DeferredResult<>(Duration.ofSeconds(4).toSeconds());
executor.submit(()-> { model.setResult(assembler.toModel(mapper.map(entity, User.class)));
model.onCompletion(() -> System.out.println("User adicionado"));
});
return model;



}

}
