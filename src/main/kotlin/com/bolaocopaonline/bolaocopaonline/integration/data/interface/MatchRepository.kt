package com.bolaocopaonline.bolaocopaonline.integration.data.`interface`

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository :  JpaRepository<Match, Long>  {
}