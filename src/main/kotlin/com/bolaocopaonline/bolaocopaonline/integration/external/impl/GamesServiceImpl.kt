package com.bolaocopaonline.bolaocopaonline.integration.external.impl

import com.bolaocopaonline.bolaocopaonline.integration.external.GamesService
import com.bolaocopaonline.bolaocopaonline.integration.external.request.GamesRequests
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder
import java.io.IOException

@Service
class GamesServiceImpl(
    @Autowired private var template: RestTemplate,
    @Autowired private var headers: HttpHeaders
) : GamesService {

    private val entity: HttpEntity<String> = HttpEntity("body", headers)

    override fun getGames(): Collection<Response> {
        val uri: UriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("v3.football.api-sports.io")
            .path("standings")
            .queryParam("league", 1)
            .queryParam("season", 2022)
            .build()

        //comentei dados de autenticação pra commit
        //headers.set(<<key>>, <<value>>)

        val result: ResponseEntity<GamesRequests> = template.exchange(uri.toUriString(), HttpMethod.GET, entity, String)

        return result.body?.response ?: throw IOException("Não foi encontrado jogos.")
    }
}