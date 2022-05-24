package com.bolaocopaonline.bolaocopaonline.integration.data.models

import java.sql.Timestamp
import java.util.Date
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "matches")
data class Match(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:ManyToOne
    @field:JoinColumn(name = "keyGroup_id", foreignKey = ForeignKey(name = "fk_keyGroup_id"), nullable = false)
    val keyGroup: KeyGroup,

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

    @field:NotNull
    val dateTime: Timestamp,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "match")
    val guesses: List<Guess>
)