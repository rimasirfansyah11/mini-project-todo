package com.project.simplecrud.service;

import com.project.simplecrud.model.entity.Todo;
import com.project.simplecrud.model.response.GetAllTodoListResponse;
import com.project.simplecrud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllTodoListService {

    private final TodoRepository todoRepository;

    public GetAllTodoListResponse getAllTodoList() {

        List<Todo> todoList = todoRepository.getAllNotDeleted();

        return GetAllTodoListResponse.builder()
                .todoList(todoList)
                .build();
    }

}
