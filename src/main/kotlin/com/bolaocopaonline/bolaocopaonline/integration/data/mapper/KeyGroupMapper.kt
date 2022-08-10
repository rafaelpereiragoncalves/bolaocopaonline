package com.bolaocopaonline.bolaocopaonline.integration.data.mapper

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.KeyGroupDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.KeyGroup
import org.springframework.stereotype.Service

@Service
class KeyGroupMapper: NewMapper<KeyGroupDTO, KeyGroup> {
    override fun fromEntity(entity: KeyGroup): KeyGroupDTO = KeyGroupDTO(
        entity.id,
        entity.name
    )

    override fun toEntity(domain: KeyGroupDTO): KeyGroup = KeyGroup(
        domain.id,
        domain.name
    )
}