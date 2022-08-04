package com.bolaocopaonline.bolaocopaonline.integration.data.dto

import java.util.*

data class UserDTO(
    val name: String,
    val email: String,
    val birthdate: Date,
    val cellNumber: String
)

data class UserDTOForm(
    val name: String,
    val password: String,
    val email: String,
    val birthdate: Date,
    val cellNumber: String,
)