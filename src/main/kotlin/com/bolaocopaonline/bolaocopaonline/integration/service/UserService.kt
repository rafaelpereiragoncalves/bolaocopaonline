package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import java.util.*

interface UserService {

    fun create(user: User) : User

    fun getAll() : List<User>

    fun getById(id: Long) : Optional<User>

    fun update(id: Long, user: UserDTO) : Optional<User>

    fun delete(id: Long)
}