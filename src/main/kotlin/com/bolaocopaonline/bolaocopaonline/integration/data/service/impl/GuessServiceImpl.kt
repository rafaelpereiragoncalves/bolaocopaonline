package com.bolaocopaonline.bolaocopaonline.integration.data.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.GuessRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Guess
import com.bolaocopaonline.bolaocopaonline.integration.data.service.GuessService
import java.util.*

class GuessServiceImpl(private val repository: GuessRepository) : GuessService {
    override fun create(guess: Guess): Guess {
        return repository.save(guess)
    }

    override fun getAll(): List<Guess> {
        return repository.findAll()
    }

    override fun getById(id: Long): Optional<Guess> {
        return repository.findById(id)
    }

    override fun update(id: Long, guess: Guess): Optional<Guess> {
        val optional = getById(id)

        return optional.map {
            val guessToUpdate = it.copy(
                name = guess.name,
                user = guess.user,
                match = guess.match
            )
            repository.save(guessToUpdate)
        }
    }

    override fun delete(id: Long) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not found.") }
    }
}