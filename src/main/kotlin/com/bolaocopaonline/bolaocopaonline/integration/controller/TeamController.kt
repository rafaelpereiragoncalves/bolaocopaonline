package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Team
import com.bolaocopaonline.bolaocopaonline.integration.data.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("teams")
class TeamController(private val service: TeamService) {

    fun create(@RequestBody team: Team): Team = service.create(team)

    @GetMapping
    fun getAll(): List<Team> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<Team> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse((ResponseEntity.notFound().build()))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody team: Team) : ResponseEntity<Team> =
        service.update(id, team).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}