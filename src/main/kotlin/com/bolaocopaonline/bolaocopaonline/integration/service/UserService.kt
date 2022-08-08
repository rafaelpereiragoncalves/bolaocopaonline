package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import java.util.*

interface UserService {

    fun createUser(userDTO: UserDTO) : UserDTO

    fun getUsers(): List<UserDTO>

    fun getUser(id: Long): UserDTO

    fun updateUser(userDTO: UserDTO): UserDTO

    fun deleteUser(id: Long)
}