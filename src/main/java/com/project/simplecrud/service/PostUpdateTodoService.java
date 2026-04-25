package com.project.simplecrud.service;

import com.project.simplecrud.model.entity.Todo;
import com.project.simplecrud.model.request.PostUpdateTodoRequest;
import com.project.simplecrud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostUpdateTodoService {

    private final TodoRepository todoRepository;

    public ResponseEntity<Void> execute(PostUpdateTodoRequest request) {
        try {
            Todo todo = todoRepository.findById(request.getId()).orElseThrow();
            todo.setName(request.getName());
            todo.setNote(request.getNote());
            todo.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
            todoRepository.save(todo);
        } catch (Exception e) {
            log.error("error occured : ".concat(e.getMessage()));
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
