package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "matches")
data class Match(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:ManyToOne(fetch = FetchType.EAGER)
    @field:JoinColumn(name = "group_id", foreignKey = ForeignKey(name = "fk_group_id"), nullable = false)
    val group: Group,

    @field:ManyToOne
    @field:JoinColumn(name = "teamOne_id", foreignKey = ForeignKey(name = "fk_teamOne_id"), nullable = false)
    val teamOne: Team,

    @field:NotNull
    val resultOne: Int,

    @field:ManyToOne
    @field:JoinColumn(name = "teamTwo_id", foreignKey = ForeignKey(name = "fk_teamTwo_id"), nullable = false)
    val teamTwo: Team,

    @field:NotNull
    val resultTwo: Int,
)