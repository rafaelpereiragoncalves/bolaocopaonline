package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.stereotype.Component

@Component
class UserMapper: Mapper<User, UserDTO> {

    override fun map(t: User): UserDTO {
        return UserDTO(
            name = t.name,
            email = t.email,
            birthdate = t.birthdate,
            cellNumber = t.cellNumber
        )
    }

}