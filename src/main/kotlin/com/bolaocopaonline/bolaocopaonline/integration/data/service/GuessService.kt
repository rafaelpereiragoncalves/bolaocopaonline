package com.bolaocopaonline.bolaocopaonline.integration.data.service

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Guess
import java.util.Optional

interface GuessService {
    fun create(guess: Guess) : Guess

    fun getAll() : List<Guess>

    fun getById(id: Long) : Optional<Guess>

    fun update(id: Long, guess: Guess) : Optional<Guess>

    fun delete(id: Long)
}