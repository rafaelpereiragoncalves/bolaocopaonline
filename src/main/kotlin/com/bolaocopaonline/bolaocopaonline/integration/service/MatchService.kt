package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Match
import java.util.Optional

interface MatchService {
    fun create(match: Match) : Match

    fun getAll() : List<Match>

    fun getById(id: Long) : Optional<Match>

    fun update(id: Long, match: Match) : Optional<Match>

    fun delete(id: Long)
}