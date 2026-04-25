package com.project.simplecrud.service;

import com.project.simplecrud.model.entity.Todo;
import com.project.simplecrud.model.request.PostCreateTodoRequest;
import com.project.simplecrud.model.response.PostCreateTodoResponse;
import com.project.simplecrud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostCreateTodoService {

    private final TodoRepository todoRepository;

    public PostCreateTodoResponse execute(PostCreateTodoRequest request) {
        Todo todo = todoRepository.save(Todo.builder()
                .name(StringUtils.defaultString(request.getName()))
                .note(StringUtils.defaultString(request.getNote()))
                .insertTime(new Timestamp(System.currentTimeMillis()))
                .build());

        return PostCreateTodoResponse.builder()
                .id(todo.getId())
                .build();
    }


}
