package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.dto.BolaoDTO
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Bolao
import com.bolaocopaonline.bolaocopaonline.integration.service.BolaoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("boloes")
class BolaoController(private val service: BolaoService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid bolaoDTO: BolaoDTO) : BolaoDTO = service.create(bolaoDTO)

    @GetMapping
    fun getAll() : List<Bolao> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Bolao> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody @Valid bolao: Bolao) : ResponseEntity<Bolao> =
        service.update(id, bolao).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}