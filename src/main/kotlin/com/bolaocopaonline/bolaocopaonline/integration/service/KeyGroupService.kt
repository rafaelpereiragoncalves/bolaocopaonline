package com.bolaocopaonline.bolaocopaonline.integration.service

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.KeyGroupDTO

interface KeyGroupService {

    fun createKeyGroup(keyGroupDTO: KeyGroupDTO) : KeyGroupDTO

    fun getKeyGroups() : List<KeyGroupDTO>

    fun getKeyGroup(id: Long) : KeyGroupDTO
}