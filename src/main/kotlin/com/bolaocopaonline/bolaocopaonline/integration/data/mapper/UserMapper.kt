package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.stereotype.Service

@Service
class UserMapper: NewMapper<UserDTO, User> {
    override fun fromEntity(entity: User): UserDTO = UserDTO(
        entity.id,
        entity.name,
        entity.password,
        entity.email,
        entity.birthdate,
        entity.cellNumber
    )

    override fun toEntity(domain: UserDTO): User = User(
        domain.id,
        domain.name,
        domain.password,
        domain.email,
        domain.birthdate,
        domain.cellNumber
    )
}