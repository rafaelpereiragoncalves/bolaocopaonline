package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.controller.utils.exceptions.UserException
import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.UserMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : UserService {

    override fun createUser(userDTO: UserDTO): UserDTO {
        val user = userRepository.save(userMapper.toEntity(userDTO))
        return userMapper.fromEntity(user)
    }

    override fun getUsers(): List<UserDTO> {
        val users = userRepository.getAllUsers()

        if(users.isEmpty())
            throw UserException("Lista de usuários vazia.")

        return users.map {
            userMapper.fromEntity(it)
        }
    }

    override fun getUser(id: Long): UserDTO {
        val optionalUser = userRepository.findById(id)
        val user = optionalUser.orElseThrow{ UserException("Usuário com id $id não existe") }
        return userMapper.fromEntity(user)
    }

    override fun updateUser(userDTO: UserDTO): UserDTO {
        val exists = userRepository.existsById(userDTO.id)

        if(!exists)
            throw UserException("Usuário com id ${userDTO.id} não existe")

        userRepository.save(userMapper.toEntity((userDTO)))
        return userDTO
    }

    override fun deleteUser(id: Long) {
        val exists = userRepository.existsById(id)

        if(!exists)
            throw UserException("Usuário com id $id não existe")

        userRepository.deleteById(id)
    }
}