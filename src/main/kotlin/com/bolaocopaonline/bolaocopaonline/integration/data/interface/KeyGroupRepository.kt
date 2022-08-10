package com.bolaocopaonline.bolaocopaonline.integration.data.`interface`

import com.bolaocopaonline.bolaocopaonline.integration.data.models.KeyGroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface KeyGroupRepository : JpaRepository<KeyGroup, Long> {

    @Query("SELECT kg FROM KeyGroup as kg")
    fun getAllKeyGroups(): List<KeyGroup>
}