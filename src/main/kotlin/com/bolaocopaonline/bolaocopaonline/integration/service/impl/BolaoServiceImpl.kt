package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.BolaoRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import com.bolaocopaonline.bolaocopaonline.integration.service.BolaoService
import com.bolaocopaonline.bolaocopaonline.integration.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class BolaoServiceImpl(private val repository: BolaoRepository, private val userService: UserService) : BolaoService {

    override fun create(bolaoDTO: BolaoDTO): BolaoDTO {
        return bolaoDTO.copy(
            name = bolaoDTO.name,
            guessesToRound = bolaoDTO.guessesToRound,
            approvalToAdmin = bolaoDTO.approvalToAdmin,
            exactScore = bolaoDTO.exactScore,
            winnerAndWinnerScoreboard = bolaoDTO.winnerAndWinnerScoreboard,
            winnerAndLoserScoreboard = bolaoDTO.winnerAndLoserScoreboard,
            tieAndNoScore = bolaoDTO.tieAndNoScore,
            winnerAndGoalDifference = bolaoDTO.winnerAndGoalDifference,
            justWinner = bolaoDTO.justWinner,
            justOneScore = bolaoDTO.justOneScore,
            userLimit = bolaoDTO.userLimit,
            administrator = userService.getById(bolaoDTO.administrator)
        )
    }

    override fun getAll(): List<Bolao> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Bolao> {
        return repository.findById(id)
    }

    override fun update(id: Long, bolao: Bolao): Optional<Bolao> {
        val optional = getById(id)

        return optional.map {
            val bolaoToUpdate = it.copy(
                name = bolao.name
            )
            repository.save(bolaoToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.") }
    }
}