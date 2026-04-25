package com.project.simplecrud.repository;

import com.project.simplecrud.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, String> {

    @Query(value = """
            SELECT * FROM 
                TODO
            where DELETED IS NULL OR DELETED IS FALSE
            """, nativeQuery = true)
    List<Todo> getAllNotDeleted();

}
