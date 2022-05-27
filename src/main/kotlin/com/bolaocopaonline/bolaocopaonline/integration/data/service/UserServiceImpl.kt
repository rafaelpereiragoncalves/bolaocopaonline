package com.bolaocopaonline.bolaocopaonline.integration.data.service

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {
    override fun create(user: User): User {
        return repository.save(user)
    }

    override fun getAll(): List<User> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<User> {
        return repository.findById(id)
    }

    override fun update(id: Long, user: User): Optional<User> {
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
        }.orElseThrow { throw RuntimeException("Id not found $")}
    }
}