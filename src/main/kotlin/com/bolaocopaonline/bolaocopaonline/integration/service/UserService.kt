package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTOForm
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import java.util.*

interface UserService {

    fun create(userDTOForm: UserDTOForm) : UserDTO

    fun getAll() : List<UserDTO>

    fun getById(id: Long) : Optional<User>

    fun update(id: Long, user: UserDTO) : Optional<User>

    fun delete(id: Long)
}