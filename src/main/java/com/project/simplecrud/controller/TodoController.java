package com.project.simplecrud.controller;

import com.project.simplecrud.model.request.PostCreateTodoRequest;
import com.project.simplecrud.model.request.PostDeleteTodoRequest;
import com.project.simplecrud.model.request.PostUpdateTodoRequest;
import com.project.simplecrud.model.response.GetAllTodoListResponse;
import com.project.simplecrud.model.response.PostCreateTodoResponse;
import com.project.simplecrud.service.GetAllTodoListService;
import com.project.simplecrud.service.PostCreateTodoService;
import com.project.simplecrud.service.PostDeleteTodoService;
import com.project.simplecrud.service.PostUpdateTodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private final PostCreateTodoService postCreateTodoService;
    private final GetAllTodoListService getAllTodoListService;
    private final PostUpdateTodoService postUpdateTodoService;
    private final PostDeleteTodoService postDeleteTodoService;

    @PostMapping("/create")
    public PostCreateTodoResponse create(@RequestBody PostCreateTodoRequest request) {
        return postCreateTodoService.execute(request);
    }

    @GetMapping("/get-all")
    public GetAllTodoListResponse getAll() {
        return getAllTodoListService.getAllTodoList();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(@RequestBody PostUpdateTodoRequest request) {
        return postUpdateTodoService.execute(request);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody PostDeleteTodoRequest request) {
        return postDeleteTodoService.execute(request);
    }
}
