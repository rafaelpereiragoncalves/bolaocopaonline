package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.UserDTOForm
import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import org.springframework.stereotype.Component

@Component
class UserFormMapper: Mapper<UserDTOForm, User> {

    override fun map(t: UserDTOForm): User {
        return User(
            id = 1,
            name = t.name,
            email = t.email,
            password = t.password,
            birthdate = t.birthdate,
            cellNumber = t.cellNumber
        )
    }

}