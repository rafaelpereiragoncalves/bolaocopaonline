package com.bolaocopaonline.bolaocopaonline.integration.data.service

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Team
import java.util.Optional

interface TeamService {
    fun create(team: Team) : Team

    fun getAll(): List<Team>

    fun getById(id: Long) : Optional<Team>

    fun update(id: Long, team: Team) : Optional<Team>

    fun delete(id: Long)
}