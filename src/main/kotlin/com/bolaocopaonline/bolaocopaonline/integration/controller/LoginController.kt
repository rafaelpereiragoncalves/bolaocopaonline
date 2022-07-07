package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.LoginDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.LoginResponseDTO
import com.bolaocopaonline.bolaocopaonline.integration.util.JWTUtils
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(val userRepository: UserRepository) {

    @PostMapping
    fun login(loginDTO: LoginDTO) : ResponseEntity<Any> {
        try{

            val userFound = userRepository.findByEmail(loginDTO.name)
            val token = JWTUtils().tokenGenerate(userFound.id.toString())

            val user = LoginResponseDTO(userFound.name, userFound.email, token)
            return ResponseEntity(user, HttpStatus.OK)

        } catch (e: Exception) {
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}