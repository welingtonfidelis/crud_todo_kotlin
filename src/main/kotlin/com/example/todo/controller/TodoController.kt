package com.example.todo.controller

import com.example.todo.model.Todo
import com.example.todo.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todo")
class TodoController {
    @Autowired
    lateinit var repository: TodoRepository

    @GetMapping()
    fun index(): List<Todo> {
        return repository.findAll()
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    fun create(@RequestBody todo: Todo): Todo {
        repository.save(todo)
        return todo
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    fun update(@PathVariable("id") id: Long, @RequestBody todo: Todo): Boolean {
        val todoUpdate: Optional<Todo> = repository.findById(id)
        if(todoUpdate.isPresent) {
            repository.save(todo)
            return true
        }

        return false
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    fun delete(@PathVariable("id") id: Long): Boolean {
        val todoUpdate: Optional<Todo> = repository.findById(id)
        if(todoUpdate.isPresent) {
            repository.deleteById(id)

            return true
        }

        return false
    }
}