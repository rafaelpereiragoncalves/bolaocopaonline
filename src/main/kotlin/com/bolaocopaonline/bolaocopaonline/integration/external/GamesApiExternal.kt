package com.bolaocopaonline.bolaocopaonline.integration.external

import com.bolaocopaonline.bolaocopaonline.integration.external.request.GamesRequests
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder

class GamesApiExternal(
    private val template: RestTemplate,
    private val games: GamesRequests
) {
    //https://v3.football.api-sports.io/standings?league=1&season=2022

    fun getGames() : ResponseEntity<GamesRequests> {
        val uri: UriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("v3.football.api-sports.io")
            .path("standings")
            .queryParam("league", 1)
            .queryParam("season", 2022)
            .build()

        val entity: ResponseEntity<GamesRequests> = template.getForEntity(uri.toUriString(), games)

//        System.out.println(entity.body)
        return entity
    }
}