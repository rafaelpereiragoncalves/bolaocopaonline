package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "guesses")
data class Guess(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50)
    val name: String
) {
    @ManyToOne
    @JoinColumn(name = "match_id", foreignKey = ForeignKey(name = "fk_match_id"), nullable = false)
    var match: Match? = null
}