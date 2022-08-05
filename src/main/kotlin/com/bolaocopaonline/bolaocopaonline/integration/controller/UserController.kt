package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun createUser(@RequestBody @Valid userDTO: UserDTO): ResponseEntity<UserDTO> =
        ResponseEntity(userService.createUser(userDTO), HttpStatus.CREATED)

    @GetMapping
    fun getUsers() : ResponseEntity<List<UserDTO>> =
        ResponseEntity.ok(userService.getUsers())

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long) =
        ResponseEntity.ok(userService.getUser(id))

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userDTO: UserDTO) : ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.updateUser(userDTO))

//
//    @DeleteMapping("/{id}")
//    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
//        service.delete(id)
//        return ResponseEntity<Void>(HttpStatus.OK)
//    }
}