package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.KeyGroupDTO
import com.bolaocopaonline.bolaocopaonline.integration.service.KeyGroupService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("keygroups")
data class KeyGroupController(
    private val keyGroupService: KeyGroupService
) {

    @PostMapping
    fun creteKeyGroup(@RequestBody @Valid keyGroupDTO: KeyGroupDTO): ResponseEntity<KeyGroupDTO> =
        ResponseEntity(keyGroupService.createKeyGroup(keyGroupDTO), HttpStatus.CREATED)

    fun getKeyGroups(): ResponseEntity<List<KeyGroupDTO>> =
        ResponseEntity.ok(keyGroupService.getKeyGroups())

}