package com.bolaocopaonline.bolaocopaonline.integration.data.`interface`

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Guess
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GuessRepository : JpaRepository<Guess, Long> {
}