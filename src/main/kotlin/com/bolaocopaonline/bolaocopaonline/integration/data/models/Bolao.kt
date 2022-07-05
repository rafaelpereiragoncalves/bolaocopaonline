package com.bolaocopaonline.bolaocopaonline.integration.data.models

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "boloes")
data class Bolao(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @field:NotNull
    @field:Size(min = 2, max = 20)
    val name: String,

    @field:NotNull
    val guessesToRound: Int,

    @field:NotNull
    val approvalToAdmin: Boolean,

    //Rules:
    @field:NotNull
    val exactScore: Int,

    @field:NotNull
    val winnerAndWinnerScoreboard: Int,

    @field:NotNull
    val winnerAndLoserScoreboard: Int,

    @field:NotNull
    val tieAndNoScore: Int,

    @field:NotNull
    val winnerAndGoalDifference: Int,

    @field:NotNull
    val justWinner: Int,

    @field:NotNull
    val justOneScore: Int,

    @field:NotNull
    val userLimit: Int,

    @field:ManyToOne
    @field:JoinColumn(name = "adm_user_id", foreignKey = ForeignKey(name = "fk_userBolao_id"), nullable = false)
    val administrator: User,

    @field:OneToMany(fetch = FetchType.LAZY, mappedBy = "bolao")
    val userBoloes: List<UserBolao> = emptyList(),

    @field:OneToMany(fetch = FetchType.LAZY, mappedBy = "bolao")
    val bolaoMatches: List<BolaoMatch> = emptyList()
)