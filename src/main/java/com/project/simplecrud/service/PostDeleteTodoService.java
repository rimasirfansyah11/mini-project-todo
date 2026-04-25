package com.project.simplecrud.service;

import com.project.simplecrud.model.entity.Todo;
import com.project.simplecrud.model.request.PostDeleteTodoRequest;
import com.project.simplecrud.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostDeleteTodoService {

    private final TodoRepository todoRepository;

    public ResponseEntity<Void> execute(PostDeleteTodoRequest request) {
        try {
            Todo todo = todoRepository.findById(request.getId()).orElseThrow();
            todo.setIsDeleted(Boolean.TRUE);
            todoRepository.save(todo);
        } catch (Exception e) {
            log.info("error deleting " + request.getId() + ", cause : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        log.info("success deleted : " + request.getId());
        return ResponseEntity.ok().build();
    }

}
