package com.bolaocopaonline.bolaocopaonline.integration.external.impl

import com.bolaocopaonline.bolaocopaonline.integration.data.`interface`.TeamRepository
import com.bolaocopaonline.bolaocopaonline.integration.data.mapper.KeyGroupMapper
import com.bolaocopaonline.bolaocopaonline.integration.data.models.Team
import com.bolaocopaonline.bolaocopaonline.integration.external.GamesService
import com.bolaocopaonline.bolaocopaonline.integration.external.request.GamesRequests
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Response
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Standing
import com.bolaocopaonline.bolaocopaonline.integration.external.request.Teamapi
import com.bolaocopaonline.bolaocopaonline.integration.service.KeyGroupService
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
    @Autowired private var headers: HttpHeaders,
    @Autowired private var service: KeyGroupService,
    @Autowired private var keyGroupMapper: KeyGroupMapper,
    @Autowired private var repository: TeamRepository,
) : GamesService {

    private val entity: HttpEntity<String> = HttpEntity("body", headers)

    override fun getTeams(): Collection<Response> {
        val uri: UriComponents = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host("v3.football.api-sports.io")
            .path("standings")
            .queryParam("league", 1)
            .queryParam("season", 2022)
            .build()

        //comentei dados de autenticação para commit
        headers.set("", "")

        val result: ResponseEntity<GamesRequests> = template.exchange(uri.toUriString(), HttpMethod.GET, entity, String)

        val standings: ArrayList<Collection<Standing>> = ArrayList()

        for(item in result.body!!.response)
        {
            for (leagues in item.league.standings)
            {
                standings.add(leagues)
            }
        }

        val group: ArrayList<Standing> = ArrayList()

        for (t in standings){
            for (item in t.map { it }) {
                group.add(item)
            }
        }

        var aux: Long = 0

        for (g in group) {
            when (g.group) {
                "Group A" -> aux = 1
                "Group B" -> aux = 2
                "Group C" -> aux = 3
                "Group D" -> aux = 4
                "Group E" -> aux = 5
                "Group F" -> aux = 6
                "Group G" -> aux = 7
                "Group H" -> aux = 8
            }

            val team: Team = Team(
                0,
                g.team.name,
                0,
                g.team.logo,
                keyGroupMapper.toEntity(service.getKeyGroup(aux))
            )

            repository.save(team)
        }

        return result.body?.response ?: throw IOException("Não foi encontrado jogos.")
    }
}