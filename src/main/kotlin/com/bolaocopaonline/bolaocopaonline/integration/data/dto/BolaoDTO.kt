package com.bolaocopaonline.bolaocopaonline.integration.data.dto

import com.bolaocopaonline.bolaocopaonline.integration.data.models.User
import java.util.*

data class BolaoDTO(
    //Bolão data
    val name: String,
    val guessesToRound: Int,
    val approvalToAdmin: Boolean
)

data class BolaoDTOForm(
    //Bolão data
    val name: String,
    val guessesToRound: Int,
    val approvalToAdmin: Boolean,

    //Rules:
    val exactScore: Int,
    val winnerAndWinnerScoreboard: Int,
    val winnerAndLoserScoreboard: Int,
    val tieAndNoScore: Int,
    val winnerAndGoalDifference: Int,
    val justWinner: Int,
    val justOneScore: Int,
    val userLimit: Int,

    //Participants:
    val administrator: Long
)