package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
data class User(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50)
    val name: String
)