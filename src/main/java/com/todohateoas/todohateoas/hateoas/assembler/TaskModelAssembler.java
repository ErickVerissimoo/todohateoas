package com.todohateoas.todohateoas.hateoas.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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
        var taskModel = mapper.map(entity, TaskModel.class);

        throw new UnsupportedOperationException("Unimplemented method 'toModel'");
    }

}
