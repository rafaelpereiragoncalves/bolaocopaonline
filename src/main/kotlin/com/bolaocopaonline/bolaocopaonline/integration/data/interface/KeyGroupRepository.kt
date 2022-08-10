package com.bolaocopaonline.bolaocopaonline.integration.data.`interface`

import com.bolaocopaonline.bolaocopaonline.integration.data.models.KeyGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KeyGroupRepository : JpaRepository<KeyGroup, Long> {

    fun getAllKeyGroups(): List<KeyGroup>
}