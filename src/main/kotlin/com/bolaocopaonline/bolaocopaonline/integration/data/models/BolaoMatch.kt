package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*

@Entity
@Table(name = "bolaomatch")
data class BolaoMatch(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:ManyToOne
    @field:JoinColumn(name = "bolao_id", foreignKey = ForeignKey(name = "fk_bolaoMatchBolao_id"), nullable = false)
    val bolao: Bolao,

    @field:ManyToOne
    @field:JoinColumn(name = "match_id", foreignKey = ForeignKey(name = "fk_matchBolaoMatch_id"), nullable = false)
    val match: Match
)