package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.UserRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTOForm
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import org.springframework.stereotype.Component

@Component
class BolaoFormMapper(private val repository: UserRepository): Mapper<BolaoDTOForm, Bolao> {
    override fun map(t: BolaoDTOForm): Bolao {
        return Bolao(
            id = 1,
            name = t.name,
            guessesToRound = t.guessesToRound,
            approvalToAdmin = t.approvalToAdmin,
            exactScore = t.exactScore,
            winnerAndWinnerScoreboard = t.winnerAndWinnerScoreboard,
            winnerAndLoserScoreboard = t.winnerAndLoserScoreboard,
            tieAndNoScore = t.tieAndNoScore,
            winnerAndGoalDifference = t.winnerAndGoalDifference,
            justWinner = t.justWinner,
            justOneScore = t.justOneScore,
            userLimit = t.userLimit,
            administrator = repository.getUserById(t.administrator)
        )
    }
}