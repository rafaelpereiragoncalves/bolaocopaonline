package com.bolaocopaonline.bolaocopaonline.integration.data.dto

data class LoginDTO(
    val name: String,
    val password: String
)

data class LoginResponseDTO(
    val name: String,
    val email: String,
    val token: String
)