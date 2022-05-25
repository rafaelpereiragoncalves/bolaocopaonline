package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*

@Entity
@Table(name = "userbolao")
data class UserBolao(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:ManyToOne
    @field:JoinColumn(name = "user_id", foreignKey = ForeignKey(name = "fk_userBolao_id"), nullable = false)
    val user: User,

    @field:ManyToOne
    @field:JoinColumn(name = "bolao_id", foreignKey = ForeignKey(name = "fk_bolaoUser_id"), nullable = false)
    val bolao: Bolao
)