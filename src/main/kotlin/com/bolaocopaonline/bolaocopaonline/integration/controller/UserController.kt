package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UserController(val repository: UserRepository) {

    @PostMapping
    fun create(@RequestBody user: User): ResponseEntity<User> {
        val userSave = repository.save(user)
        return ResponseEntity.ok(userSave)
    }
}