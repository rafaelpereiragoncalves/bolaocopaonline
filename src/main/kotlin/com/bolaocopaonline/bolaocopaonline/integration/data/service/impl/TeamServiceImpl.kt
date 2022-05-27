package com.bolaocopaonline.bolaocopaonline.integration.data.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.TeamRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Team
import com.bolaocopaonline.bolaocopaonline.integration.data.service.TeamService
import org.springframework.stereotype.Service
import java.util.*

@Service
class TeamServiceImpl(private val repository: TeamRepository) : TeamService {
    override fun create(team: Team): Team {
        return repository.save(team)
    }

    override fun getAll(): List<Team> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Team> {
        return repository.findById(id)
    }

    override fun update(id: Long, team: Team): Optional<Team> {
        val optional = getById(id)

        return optional.map {
            val teamToUpdate = it.copy(
                name = team.name,
                groupStageScore = team.groupStageScore,
                teamFlag = team.teamFlag,
                keyGroup = team.keyGroup
            )
            repository.save(teamToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.")}
    }
}