package com.todohateoas.todohateoas.hateoas.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.HttpMethod;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import com.todohateoas.todohateoas.controller.TaskController;
import com.todohateoas.todohateoas.hateoas.model.TaskModel;
import com.todohateoas.todohateoas.model.Task;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Component
public class TaskModelAssembler implements RepresentationModelAssembler<Task, TaskModel> {
    private final ModelMapper mapper;
    @NonNull
    @Override
     public TaskModel toModel(@NonNull Task entity) {
        TaskModel model = mapper.map(entity, TaskModel.class);
        Method method2 = ClassUtils.getMethod(TaskController.class, "deleteTask", String.class);

        Method method = ClassUtils.getMethod(TaskController.class, "findTask", String.class);
        model.add(linkTo(method).withRel("find one").withType(HttpMethod.POST.name()));
        model.add(linkTo(method2).withRel("delete").withType(HttpMethod.DELETE.name()));
        
        return  model;
    }

}
