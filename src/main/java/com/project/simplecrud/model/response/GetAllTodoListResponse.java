package com.project.simplecrud.model.response;

import com.project.simplecrud.model.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllTodoListResponse {
    private List<Todo> todoList;
}
