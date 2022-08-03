package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val repository: UserRepository,
    private val users: List<User>
) : UserService {
    override fun create(user: User): User {
        return repository.save(user)
    }

    override fun getAll(): List<User> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<User> {
        return repository.findById(id)
    }

    override fun update(id: Long, user: UserDTO): Optional<User> {
        val optional = getById(id)

        return optional.map {
            val userToUpdate = it.copy(
                name = user.name,
                email = user.email,
                birthdate = user.birthdate,
                cellNumber = user.cellNumber
            )
            repository.save(userToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.")}
    }
}