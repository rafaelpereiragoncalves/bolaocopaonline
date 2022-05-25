package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "teams")
data class Team(
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50)
    val name: String,

    @field:NotNull
    val groupStageScore: Int,

    @field:NotNull
    val teamFlag: Byte,

    @field:ManyToOne
    @field:JoinColumn(name = "keyGroup_id", foreignKey = ForeignKey(name = "fk_keyGroupTeam_id"), nullable = false)
    val keyGroup: KeyGroup,

    @field:OneToMany(fetch = FetchType.LAZY, mappedBy = "teamOne")
    val matches: List<Match>? = emptyList()
)