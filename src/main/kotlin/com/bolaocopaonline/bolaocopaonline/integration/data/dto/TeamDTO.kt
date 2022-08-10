package com.bolaocopaonline.bolaocopaonline.integration.data.dto

import com.bolaocopaonline.bolaocopaonline.integration.data.models.KeyGroup

data class TeamDTO(
    var id: Long,
    val name: String,
    val groupStageScore: Int,
    val teamFlag: Byte,
    val keyGroup: Long
)