package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTOForm
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.UserFormMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.UserMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class UserServiceImpl(
    private val repository: UserRepository,
    private var users: List<User>,
    private val userMapper: UserMapper,
    private val userFormMapper: UserFormMapper
) : UserService {
    override fun create(userDTOForm: UserDTOForm): UserDTO {
        val user = userFormMapper.map(userDTOForm)
        user.id = users.size.toLong() + 1
        users = users.plus(user)
        repository.save(user)
        return userMapper.map(user)
    }

    override fun getAll(): List<UserDTO> {
        return users.stream().map {
            u -> userMapper.map(u)
        }.collect(Collectors.toList())
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