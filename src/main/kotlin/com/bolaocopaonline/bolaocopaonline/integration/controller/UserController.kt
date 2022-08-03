package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(private val service: UserService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid user: User): User = service.create(user)

    @GetMapping
    fun getAll(): List<User> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<User> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse((ResponseEntity.notFound().build()))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: UserDTO) : ResponseEntity<User> =
        service.update(id, user).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}