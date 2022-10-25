package com.bolaocopaonline.bolaocopaonline.integration.controller

import com.bolaocopaonline.bolaocopaonline.integration.data.models.Team
import com.bolaocopaonline.bolaocopaonline.integration.external.GamesService
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Response
import com.bolaocopaonline.bolaocopaonline.integration.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("teams")
class TeamController(
    private val service: TeamService,
    private val serviceGames: GamesService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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

    @GetMapping("/extract")
    fun getMatches(): Collection<Response> = serviceGames.getGames()
}