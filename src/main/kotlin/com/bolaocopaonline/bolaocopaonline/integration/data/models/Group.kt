package com.bolaocopaonline.bolaocopaonline.integration.data.models

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "groups")
data class Group(

    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @field:Size(min = 5, max = 50)
    val name: String,

    @field:OneToMany(cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER, mappedBy = "group")
    val matches: List<Match>
)