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
    @field:Size(min = 2, max = 50)
    var name: String,

    @field:NotNull
    var groupStageScore: Int,

    @field:NotNull
    var teamFlag: String,

    @field:ManyToOne
    @field:JoinColumn(name = "keyGroup_id", foreignKey = ForeignKey(name = "fk_keyGroupTeam_id"), nullable = false)
    var keyGroup: KeyGroup?,

    @field:OneToMany(fetch = FetchType.LAZY, mappedBy = "teamOne")
    var matches: List<Match>? = emptyList()
)