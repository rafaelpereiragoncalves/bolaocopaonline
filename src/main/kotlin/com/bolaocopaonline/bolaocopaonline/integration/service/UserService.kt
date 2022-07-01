package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

interface UserService {

    fun create(user: User) : User

    fun getAll() : List<User>

    fun getById(id: Long) : Optional<User>

    fun update(id: Long, user: User) : Optional<User>

    fun delete(id: Long)
}