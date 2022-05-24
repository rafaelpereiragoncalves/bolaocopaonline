package com.bolaocopaonline.bolaocopaonline.integration.data.models

import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
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
    val name: String,

    @field:Email
    val email: String,

    @field:NotNull
    val birthdate: Date,

    @field:NotNull
    val cellNumber: String,

    @field:ManyToOne
    @field:JoinColumn(name = "fk_bolao_id", columnDefinition = "bigint")
    val bolao: Bolao
)