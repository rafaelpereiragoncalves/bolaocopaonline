package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.MatchRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Match
import com.bolaocopaonline.bolaocopaonline.integration.service.MatchService
import org.springframework.stereotype.Service
import java.util.*

@Service
class MatchServiceImpl(private val repository: MatchRepository) : MatchService {
    override fun create(match: Match): Match {
        return repository.save(match)
    }

    override fun getAll(): List<Match> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Match> {
        return repository.findById(id)
    }

    override fun update(id: Long, match: Match): Optional<Match> {
        val optional = getById(id)

        return optional.map {
            val matchToUpdate = it.copy(
                keyGroup = match.keyGroup,
                teamOne = match.teamOne,
                resultOne = match.resultOne,
                teamTwo = match.teamTwo,
                resultTwo = match.resultTwo,
                dateTime = match.dateTime
            )
            repository.save(matchToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.") }
    }
}