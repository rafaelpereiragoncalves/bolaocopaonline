package com.bolaocopaonline.bolaocopaonline.integration.service.impl

import com.bolaocopaonline.bolaocopaonline.integration.controller.utils.exceptions.KeyGroupException
import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.KeyGroupRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.dto.KeyGroupDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.KeyGroupMapper
import com.bolaocopaonline.bolaocopaonline.integration.service.KeyGroupService
import org.springframework.stereotype.Service

@Service
class KeyGroupServiceImpl(
    private val keyGroupRepository: KeyGroupRepository,
    private val keyGroupMapper: KeyGroupMapper
) : KeyGroupService {

    override fun createKeyGroup(keyGroupDTO: KeyGroupDTO): KeyGroupDTO {
        val keyGroup = keyGroupRepository.save(keyGroupMapper.toEntity(keyGroupDTO))
        return keyGroupMapper.fromEntity(keyGroup)
    }

    override fun getKeyGroups(): List<KeyGroupDTO> {
        val keyGroups = keyGroupRepository.getAllKeyGroups()

        if(keyGroups.isEmpty())
            throw KeyGroupException("Lista de grupos vazia.")

        return keyGroups.map {
            keyGroupMapper.fromEntity(it)
        }
    }

    override fun getKeyGroup(id: Long): KeyGroupDTO {
        val optionalKeyGroup = keyGroupRepository.findById(id)
        val keyGroup = optionalKeyGroup.orElseThrow{ KeyGroupException("Grupo com id $id não existe.") }
        return keyGroupMapper.fromEntity(keyGroup)
    }

}